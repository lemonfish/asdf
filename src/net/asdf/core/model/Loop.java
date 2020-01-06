

package net.asdf.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;

public class Loop {

    public static <T extends StatefullModel> void insert(List<T> list, Consumer<T> consumer) {
        loop(list, StatefullModel.STATUS_INSERT, consumer);
    }

    public static <T extends StatefullModel> void delete(List<T> list, Consumer<T> consumer) {
        loop(list, StatefullModel.STATUS_DELETE, consumer);
    }

    public static <T extends StatefullModel> void update(List<T> list, Consumer<T> consumer) {
        loop(list, StatefullModel.STATUS_UPDATE, consumer);
    }

    public static <T extends StatefullModel> void normal(List<T> list, Consumer<T> consumer) {
        loop(list, StatefullModel.STATUS_NORMAL, consumer);
    }

    private static String[] STATUS_UNDEFINED = new String[] {
    		StatefullModel.STATUS_DELETE,
    		StatefullModel.STATUS_INSERT,
    		StatefullModel.STATUS_NORMAL,
    		StatefullModel.STATUS_UPDATE
    };

	private static String[] STATUS_OTHER = new String[] {
			StatefullModel.STATUS_DELETE,
			StatefullModel.STATUS_INSERT,
			StatefullModel.STATUS_UPDATE
	};

    public static <T extends StatefullModel> void undefined(List<T> list, Consumer<T> consumer) {
        list.stream().filter(p -> StringUtils.indexOfAny(p.getRowStatus(), STATUS_UNDEFINED) == -1).forEachOrdered(consumer);
    }

    public static <T extends StatefullModel> void other(List<T> list, Consumer<T> consumer) {
        list.stream().filter(p -> StringUtils.indexOfAny(p.getRowStatus(), STATUS_OTHER) == -1).forEachOrdered(consumer);
    }

    public static <T extends StatefullModel> void all(List<T> list, Consumer<T> consumer) {
        list.stream().forEachOrdered(consumer);
    }

    /**
     * 특정 상태의 데이터를 순회하며 처리한다.
     * <p>
     * 사용예)
     * </p>
     * <code>
     * Loop.loop(list, StatefullModel.STATUS_INSERT, model -&gt; dao.insert("queryId", model));
     * </code>
     *
     * @param list
     *            순회할 데이터 목록
     * @param status
     *            처리할 데이터의 상태
     * @param consumer
     *            처리할 람다 표현식 혹은 구문
     */
    public static <T extends StatefullModel> void loop(List<T> list, String status, Consumer<T> consumer) {
        list.stream().filter(p -> status.equals(p.getRowStatus())).forEachOrdered(consumer);
    }

    public static <T extends Map<String, Object>> void loopMap(List<T> list, String status, Consumer<T> consumer) {
        list.stream().filter(p -> status.equals(p.get(StatefullModel.ROW_STATUS_FIELD))).forEachOrdered(consumer);
    }

}
