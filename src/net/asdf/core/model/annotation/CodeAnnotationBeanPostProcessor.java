package net.asdf.core.model.annotation;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ClassUtils;

import net.asdf.core.model.Model;

public class CodeAnnotationBeanPostProcessor implements BeanFactoryPostProcessor {

	private Map<String, String> 저장소;

	@Autowired
	private BeanFactory beanFactory;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		for(String beanName : configurableListableBeanFactory.getBeanNamesForType(Model.class)) {
			BeanDefinition beanDef = configurableListableBeanFactory.getBeanDefinition(beanName);
			if(!BeanDefinition.SCOPE_PROTOTYPE.equals(beanDef.getScope())) {
				beanDef.setScope(BeanDefinition.SCOPE_PROTOTYPE);
			}
			try {
				Class<?> klass = ClassUtils.forName(beanDef.getBeanClassName(), getClass().getClassLoader());
				List<Field> 코드필드목록 = FieldUtils.getFieldsListWithAnnotation(klass, Code.class);
				for(Field 코드필드 : 코드필드목록) {
					저장소.put(beanName + "." + 코드필드.getName(), 코드필드.getAnnotation(Code.class).value()[0]);
				}
			} catch (ClassNotFoundException | LinkageError e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void 저장소설정() {
		if(저장소 == null) {
			저장소 = beanFactory.getBean("모델코드맵", Map.class);
		}
	}

	public void set저장소(Map<String, String> 저장소) {
		this.저장소 = 저장소;
	}


}
