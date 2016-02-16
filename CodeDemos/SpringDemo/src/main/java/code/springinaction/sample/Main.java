package code.springinaction.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
//@ContextConfiguration(classes = SampleConfig.class)
//@Component
public class Main {
    //@Autowired
    public SampleBean sampleBean;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SampleConfig.class);
        /*SampleBean bean = (SampleBean) context.getBean("sampleBean");
        System.out.println(bean.getData());
        System.out.println(bean.getDependent().getData());
        SampleBean newBean = (SampleBean) context.getBean("newSampleBean");
        System.out.println(newBean.getData());
        System.out.println(newBean.getDependent().getData());*/
        /*Main main = new Main();
        System.out.println(main.sampleBean == null);*/
        Main main = context.getBean(Main.class);
        System.out.println(main == null);
        //System.out.println(main.sampleBean == null);
    }
}
