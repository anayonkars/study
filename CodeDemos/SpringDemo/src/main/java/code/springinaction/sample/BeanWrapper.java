package code.springinaction.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
@Component
public class BeanWrapper {
    private Bean bean;

    public BeanWrapper() {
        System.out.println("BeanWrapper Created");
    }

    @Autowired
    @Qualifier("AnotherBeanImplementation")
    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public Bean getBean() {
        return bean;
    }
}
