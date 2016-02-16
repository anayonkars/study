package code.springinaction.soundsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by anayonkar on 30/1/16.
 */
@Component
@Qualifier("SampleAlbum")
public class SampleAlbum implements CompactDisc {
    private String title = "SampleAlbumTitle";
    private String artist = "SampleAlbumArtist";
    @Override
    public void play() {
        System.out.println("Playing " + this.title + " by " + this.artist);
    }
}
