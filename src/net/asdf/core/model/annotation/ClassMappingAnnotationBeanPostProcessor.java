package net.asdf.core.model.annotation;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ClassUtils;

import net.asdf.core.model.Model;

public class ClassMappingAnnotationBeanPostProcessor implements BeanFactoryPostProcessor {

	private Map<String, Class<? extends Model>> 저장소;

	@Autowired
	private BeanFactory beanFactory;


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		for(String beanName : configurableListableBeanFactory.getBeanNamesForAnnotation(ClassMapping.class)) {
			BeanDefinition beanDef = configurableListableBeanFactory.getBeanDefinition(beanName);
			if(!BeanDefinition.SCOPE_PROTOTYPE.equals(beanDef.getScope())) {
				beanDef.setScope(BeanDefinition.SCOPE_PROTOTYPE);
			}
			try {
				@SuppressWarnings("unchecked")
				Class<? extends Model> klass = (Class<? extends Model>) ClassUtils.forName(beanDef.getBeanClassName(), getClass().getClassLoader());
				ClassMapping 클래스매핑 = klass.getAnnotation(ClassMapping.class);
				for(String 매핑키 : 클래스매핑.value()) {
					저장소.put(매핑키, klass);
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
			저장소 = beanFactory.getBean("클래스매핑맵", Map.class);
		}
	}

	public void set저장소(Map<String, Class<? extends Model>> 저장소) {
		this.저장소 = 저장소;
	}

}
