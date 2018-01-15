
package net.asdf.core.query;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import net.asdf.core.exception.SysException;
import net.asdf.core.model.Model;


@Component
public class SqlParameterSourceBuilder {

    private Logger logger = LogManager.getLogger();

    @Value("#{config_template['singlevaluename' ?: 'value']}")
    private String singleValueName = "value";


	/**
	 * 쿼리 실행 시 사용될 파라미터를 생성한다.
	 *
	 * 파라미터는
	 * <ul>
	 * <li>기본 데이터 타입 혹은 기본 데이터 타입을 감싼 객체</li>
	 * <li>Map 구현체
	 * <li>
	 * <li>Model 하위 클래스의 객체
	 * <li>
	 * </ul>
	 * 일 수 있다.
	 *
	 * @param param
	 *            쿼리 파라미터로 변환 할 원본 파라미터
	 * @return 쿼리 파라미터 형태로 변환된 파라미터를 지닌 SqlParameterSource
	 */
    public SqlParameterSource build(Object param) {

        SqlParameterSource sps = null;

        Class<?> clazz = null;

        if ((param == null) || (clazz = param.getClass()).isEnum() || clazz.isArray() || clazz.isAnonymousClass()
                || (clazz == Class.class)) {
			/* 지원 안함 */
            sps = EmptySqlParameterSource.INSTANCE;
        } else if (ClassUtils.isPrimitiveOrWrapper((clazz = param.getClass()))
                || String.class.isAssignableFrom(clazz)
                || SqlParameterValue.class.isAssignableFrom(clazz)) {
			/* 단일 값 */
            sps = buildSingleValue(param);
        } else if (Map.class.isAssignableFrom(clazz)) {
			/* 맵 */
            sps = build((Map<String, Object>) param);
		} else if (Model.class.isAssignableFrom(clazz)) {
			/* 모델(빈) */
			sps = build((Model) param);
        } else {
            throw new SysException("지원하지 않는 유형의 파라미터입니다. : { %s }", clazz.getCanonicalName());
        }

        return sps;
    }

    /**
     * 단일 값으로 부터 SqlParameterSource를 생성한다.
     *
     * @param name
     * @param param
     * @return
     */
    private SqlParameterSource buildSingleValue(Object value) {
        Map<String, Object> expandedMap = new HashMap<String, Object>();
        expandedMap.put(singleValueName, value);
        return new MapSqlParameterSource(expandedMap);
    }

    /**
     * 맵 구현체로 부터 SqlParameterSource를 생성한다.
     *
     * @param paramMap
     * @return
     */
    private <T extends Map<String, Object>> SqlParameterSource build(T paramMap) {
        int size = 0;
        if ((paramMap == null) || ((size = paramMap.size()) == 0)) {
            return EmptySqlParameterSource.INSTANCE;
        }

        Map<String, Object> expandedMap = new HashMap<String, Object>(size);
        expandMap(expandedMap, "", paramMap);
        return new MapSqlParameterSource(expandedMap);
    }

	private <T extends Model> SqlParameterSource build(T model) {
        if (model == null) {
            return EmptySqlParameterSource.INSTANCE;
        }

        Map<String, Object> expandedMap = new HashMap<String, Object>();
        expandBean(expandedMap, "", model);
        return new MapSqlParameterSource(expandedMap);

        // TODO 나중에 이거 사용하는걸로 변경
		//return new BeanPropertySqlParameterSource(model);
    }

    /**
     * Map 구현체의 각 요소의 키를 지정된 네임스페이스가 적용된 형태로 확장한다.
     *
     * @param expandedMap
     * @param namespacePrefix
     * @param paramMap
     */
    private void expandMap(Map<String, Object> expandedMap, String namespacePrefix, Map<String, Object> paramMap) {
        int size = 0;
        if ((size = paramMap.size()) == 0) {
            return;
        }

        StringBuilder namespace = new StringBuilder(namespacePrefix);
        int namespaceOffset = 0;
        if (!"".equals(namespacePrefix)) {
            namespace.append('.');
            namespaceOffset = namespace.length();
        }

        Set<String> keySet = paramMap.keySet();

        String[] keys = keySet.toArray(new String[keySet.size()]);
        for (String key : keys) {

            String name = namespace.append(key).toString();
            namespace.setLength(namespaceOffset);

            Object value = paramMap.get(key);
            logger.trace("expand {} to {} value : {} {}", key, name, value, value != null ? value.getClass() : "null");
            expand(expandedMap, name, value);
        }
    }

    private void expand(Map<String, Object> expandedMap, String name, Object value) {
        Class<?> clazz = null;
        // String과 null, Primitive, PrimitiveWrapper 유형은 값을 그대로 사용
        if ((value == null) || ClassUtils.isPrimitiveOrWrapper((clazz = value.getClass()))
                || String.class.isAssignableFrom(clazz)
                || SqlParameterValue.class.isAssignableFrom(clazz) || BigDecimal.class.isAssignableFrom(clazz)) {
            expandedMap.put(name, value);
        } else if (Map.class.isAssignableFrom(clazz)) {
            expandMap(expandedMap, name, ((Map<String, Object>) value));
		} else if (Model.class.isAssignableFrom(clazz)) {
			// TODO CombinedSqlParameterSource 처리 필요
			expandBean(expandedMap, name, value);
        } else if (clazz.isEnum() || clazz.isArray() || clazz.isAnonymousClass() || (clazz == Class.class) || List.class.isAssignableFrom(clazz)) {
            // enum, array, List, anonymous class, class는 제외한다.
        } else {
            throw new SysException("지원하지 않는 유형의 파라미터입니다. : { %s : %s }", name, clazz.getCanonicalName());
        }
    }

    /**
     * 빈의 멤버 필드 중 transient 를 제외한 모든 접근 가능한 필드를 지정된 네임스페이스가 적용된 형태로 확장한다.
     *
     * @param map
     * @param namespacePrefix
     * @param paramBean
     */
    private void expandBean(Map<String, Object> expandedMap, String namespacePrefix, Object paramBean) {
        StringBuilder namespace = new StringBuilder(namespacePrefix);
        int namespaceOffset = 0;
        if (!"".equals(namespacePrefix)) {
            namespace.append('.');
            namespaceOffset = namespace.length();
        }

        BeanMap beanMap = new BeanMap(paramBean) {

            @Override
            public Object get(Object name) {
                return super.get(name);
            }

        };
        Set<Object> keySet = beanMap.keySet();

        String[] keys = keySet.toArray(new String[keySet.size()]);
        for (String key : keys) {

            String name = namespace.append(key).toString();
            namespace.setLength(namespaceOffset);

            Object value = beanMap.get(key);
            expand(expandedMap, name, value);
        }
    }


}