package code.springinaction.soundsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
@Component
@Qualifier("AnotherSampleAlbum")
public class AnotherSampleAlbum implements CompactDisc {
    @Override
    public void play() {

    }
}
