package code.springinaction.aspect;

import org.springframework.stereotype.Component;

/**
 * Created by anayonkar on 17/2/16.
 */
@Component
public class BadPerformance implements Performance {
    @Override
    public void perform() throws AspectException {
        System.out.println("BadPerformance");
        throw new AspectException();
    }
}
