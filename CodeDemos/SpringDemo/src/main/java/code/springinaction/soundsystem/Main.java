package code.springinaction.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
@ContextConfiguration(classes=CDPlayerConfig.class)
@Component
public class Main {
    @Autowired
    private CDPlayer cdPlayer;

 /*   @Autowired
    @Qualifier("SampleAlbum")
    private CompactDisc compactDisc;*/

    public CDPlayer getCdPlayer() {
        return cdPlayer;
    }

   /* public CompactDisc getCompactDisc() {
        return compactDisc;
    }*/

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        //Main main = new Main();
        Main main = context.getBean(Main.class);
        //System.out.println(main.getCdPlayer() == null);
        //main.getCdPlayer().play();
        //System.out.println(main.getCompactDisc() == null);
        main.getCdPlayer().play();
    }
}
