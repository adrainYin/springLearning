package ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@Component
public class SubMediaPlayer implements MediaPlayer{

    private CDplayer cDplayer;

    /**
     * 因为subMediaPlayer需要依赖CDplayer，那么在构造函数传参数的时候就可以设置为自动装配，实例化该bean的时候
     * 自动传入一个实例化的CDplayer的bean(注意该bean对象并不一定存在)
     * 三种情况：(1)Spring在容器中找到唯一的cdPlayerBean那么装配
     * (2) 不存在 会报空指针
     * (3) 多个Bean实例，也会报错
     * @param cDplayer
     */
    @Autowired //自动装配，自动在bean容器中寻找合适的bean对象
    public SubMediaPlayer(CDplayer cDplayer){
        this.cDplayer = cDplayer;
    }


    @Override
    public void fun() {
        cDplayer.play();
    }

}
