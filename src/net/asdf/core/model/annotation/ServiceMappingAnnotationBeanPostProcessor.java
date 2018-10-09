package net.asdf.core.model.annotation;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.CannotLoadBeanClassException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.ClassUtils;

public class ServiceMappingAnnotationBeanPostProcessor implements BeanFactoryPostProcessor {

	private Map<String, Object> 저장소;

	private BeanFactory beanFactory;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void 저장소설정() {
		if(저장소 == null) {
			저장소 = beanFactory.getBean("서비스매핑맵", Map.class);
		}
	}

	public void set저장소(Map<String, Object> 저장소) {
		this.저장소 = 저장소;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		String[] beanNames = configurableListableBeanFactory.getBeanNamesForAnnotation(ServiceMapping.class);
		for(String beanName : beanNames) {
			BeanDefinition beanDef = configurableListableBeanFactory.getBeanDefinition(beanName);
			ServiceMapping 서비스매핑;
			try {
				서비스매핑 = ClassUtils.forName(beanDef.getBeanClassName(), configurableListableBeanFactory.getBeanClassLoader()).getAnnotation(ServiceMapping.class);
			} catch (ClassNotFoundException e) {
				throw new CannotLoadBeanClassException("서비스매핑 서비스", beanName, beanDef.getBeanClassName(), e);
			} catch (LinkageError e) {
				throw new FatalBeanException("서비스매핑 서비스", e);
			}

			저장소.put(beanName, 서비스매핑.value());
		}
	}

	@EventListener
	public void extractServiceMapping(ContextRefreshedEvent event) {
		ApplicationContext ctx = event.getApplicationContext();
		Map<String, Object> serviceMappedBeanMap = ctx.getBeansWithAnnotation(ServiceMapping.class);
		for(String beanName : serviceMappedBeanMap.keySet()) {
			Object bean  = serviceMappedBeanMap.get(beanName);
			for(String 매핑키 : (String[])저장소.get(beanName)) {
				저장소.put(매핑키, bean);
			}
			저장소.remove(beanName);
		}
	}


}
