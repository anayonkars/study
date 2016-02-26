package code.springinaction.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
@ContextConfiguration(classes = SampleConfig.class)
@Component
public class Start {

    @Autowired
    private BeanWrapper beanWrapper;

    @Autowired
    private BeanWrapper anotherBeanWrapper;

    public BeanWrapper getAnotherBeanWrapper() {
        return anotherBeanWrapper;
    }

    public BeanWrapper getBeanWrapper() {
        return beanWrapper;
    }

    public Start() {
        System.out.println("Start bean created");
    }
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SampleConfig.class);
        Start start = context.getBean(Start.class);
        System.out.println(start);
        start.getBeanWrapper().getBean().method();
        System.out.println(start.getBeanWrapper() == start.getAnotherBeanWrapper());
    }
}
