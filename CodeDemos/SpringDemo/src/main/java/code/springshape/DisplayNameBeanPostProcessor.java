package code.springshape;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor, Ordered {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("In postProcessAfterInitialization. Bean name is " + beanName);
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("In postProcessBeforeInitialization. Bean name is " + beanName);
		return bean;
	}

	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
