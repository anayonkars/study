package code.springinaction.aspectxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ANAYONKS on 18/02/2016.
 */
public class Main {
    private Performance good;
    private Performance bad;
    public Main() {
        //System.out.println("Main created");
    }

    public Performance getGood() {
        return good;
    }

    public Performance getBad() {
        return bad;
    }

    public void setGood(Performance good) {
        this.good = good;
    }

    public void setBad(Performance bad) {
        this.bad = bad;
    }

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("springinaction_aop.xml");
        context.registerShutdownHook();
        Main main = (Main) context.getBean("main");
        /*System.out.println(main == null);
        System.out.println(main.getGood() == null);
        System.out.println(main.getBad() == null);*/
        try {
            main.getGood().perform();
            main.getBad().perform();
        } catch (AspectException e) {
            System.out.println("Exception occurred :" + e);
        }

    }
}
