package code.springinaction.aspect;

import org.springframework.stereotype.Component;

/**
 * Created by anayonkar on 17/2/16.
 */
@Component
public class BadPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("BadPerformance");
        int x = 1/0;
    }
}
