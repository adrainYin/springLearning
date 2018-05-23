package ch04;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class TestAOP {

    @Autowired
    private CompactDisc compactDisc;
    @Autowired
    private TrackCount trackCount;
    @Autowired
    private Performance performance;

    /**
     * 测试代码，在主业务执行逻辑时调用了切面方法
     */
    @Test
    public void testTrackCount(){
        compactDisc.trackPlay(1);
        compactDisc.trackPlay(1);
        compactDisc.trackPlay(3);
        compactDisc.trackPlay(2);
        compactDisc.trackPlay(1);
        compactDisc.trackPlay(1);
        compactDisc.trackPlay(2);

        assertEquals(4, trackCount.gettrackCounts(1));
        assertEquals(2, trackCount.gettrackCounts(2));
        assertEquals(1, trackCount.gettrackCounts(3));
    }

    @Test
    public void testPerformance(){
        performance.play();
    }
}
