package ch02;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;

public class Disc {

    private String title;
    private String artist;
    private BlankDisc blankDisc;
    public Disc(
            /**
             * 使用SPEL表达式动态完成属性的注入
             * T()运算符是对Class作用域的引用，在此处会生成class对象
             * 但是该运算符分主要用途是运用静态的方法和常量
             * 在SPEL表达式中运用的字符串都需要用单引号来表示
             * 运用正则表达式的匹配项，返回boolean值
             * eq运算符表示字符串的匹配，可以直接用在SpEL表达式中
             * exp:list.?[string eq 'hello'] 匹配出list集合中String属性为hello的值 得到新的子集
             */
            @Value("#{blankDisc.name matches '[a-zA-Z]*'}") String title,
            @Value("#{systemProperties['disc.artist']}") String artist,
            //在这里是根据bean的iD标识找到相应的bean对象
            @Value("#{blankDisc}") BlankDisc blankDisc){
        this.title = title;
        this.artist = artist;
        this.blankDisc = blankDisc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
