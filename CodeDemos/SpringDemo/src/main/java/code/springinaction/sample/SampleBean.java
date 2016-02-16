package code.springinaction.sample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
//@Component
public class SampleBean /*implements BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        BeanPostProcessor,
        InitializingBean,
        DisposableBean*/ {
    private int data;
    private Dependent dependent;

    public SampleBean() {
        System.out.println("SampleBean Created");
    }

    public SampleBean(int data) {
        this();
        this.data = data;
        System.out.println("Data : " + this.data);
    }

    public SampleBean(int data, Dependent dependent) {
        this(data);
        this.dependent = dependent;
    }

    public int getData() {
        return data;
    }

    public Dependent getDependent() {
        return dependent;
    }

    /*@Override
    public void setBeanName(String s) {
        System.out.println("setBeanName called with " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory called with " + beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext called with " + applicationContext);
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization called with " + o + "\t" + s);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization called with " + o + "\t" + s);
        return null;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called");
    }*/
}
