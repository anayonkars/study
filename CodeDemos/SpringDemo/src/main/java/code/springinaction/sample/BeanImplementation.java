package code.springinaction.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
@Qualifier("BeanImplementation")
@Component
public class BeanImplementation implements Bean {
    @Override
    public void method() {
        System.out.println("BeanImplementation");
    }
}
