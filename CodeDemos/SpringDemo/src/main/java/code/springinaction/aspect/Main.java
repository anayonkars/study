package code.springinaction.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by anayonkar on 17/2/16.
 */
@Component
public class Main {
    @Autowired
    private Performance good;

    @Autowired
    private Performance bad;

    public Performance getGood() {
        return good;
    }

    public Performance getBad() {
        return bad;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Main main = context.getBean(Main.class);
        try {
            main.getGood().perform();
            main.getBad().perform();
        } catch (AspectException e) {
            System.out.println("Exception occurred :" + e);
        }
    }
}
