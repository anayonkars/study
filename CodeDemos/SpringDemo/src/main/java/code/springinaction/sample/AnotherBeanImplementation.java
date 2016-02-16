package code.springinaction.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
@Qualifier("AnotherBeanImplementation")
@Component
public class AnotherBeanImplementation implements Bean {
    @Override
    public void method() {
        System.out.println("AnotherBeanImplementation");
    }
}
