package ch04;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

//@Aspect
public class TrackCount {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    /**
     * 定义带参数的切点, trackNumber要和方法签名中的参数名匹配
     *  可以理解为将连接点中的int类型参数传入到了切点函数中
     *  表明传递给trackPlay方法的int类型参数也会传递到通知汇中去，与切点方法匹配
     * @param trackNumber 传递的参数
     */
    //@Pointcut("execution(* ch04.CompactDisc.trackPlay(int)) && args(trackNumber)")
    //args中的限定符需要和切点方法签名中的相匹配
    public void trackPlayed(int trackNumber){}

    /**
     * 这里的trackNumber引用的就是trackPlayed方法中的参数
     * @param trackNumber
     */
    //@Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber){
        if (!trackCounts.containsKey(trackNumber)){
            trackCounts.put(trackNumber, 0);
        }
        int currTrackCount = trackCounts.get(trackNumber);
        trackCounts.put(trackNumber, currTrackCount + 1);
   }

    public int gettrackCounts(int trackNumber){
        return trackCounts.containsKey(trackNumber)? trackCounts.get(trackNumber) : 0 ;
    }
}
