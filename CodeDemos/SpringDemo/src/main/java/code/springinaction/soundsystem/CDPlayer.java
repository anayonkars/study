package code.springinaction.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by anayonkar on 30/1/16.
 */
@Component
public class CDPlayer {
    private CompactDisc cd;

    /*@Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
        System.out.println(this.cd == null);
    }*/


    @Autowired
    @Qualifier("SampleAlbum")
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        this.cd.play();
    }
}
