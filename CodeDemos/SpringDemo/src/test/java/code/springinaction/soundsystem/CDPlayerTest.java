package code.springinaction.soundsystem;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anayonkar on 30/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CDPlayer cdPlayer;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        Assert.assertNotNull(cd);
    }

    @Test
    public void play() {
        cdPlayer.play();
        Assert.assertEquals("Playing " + "SampleAlbumTitle" + " by " + "SampleAlbumArtist" + "\n",
                log.getLog());
    }
}
