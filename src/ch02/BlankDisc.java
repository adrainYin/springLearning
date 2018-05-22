package ch02;

import java.util.List;

public class BlankDisc {

    private String name;
    private int num;
    private List<String> list;

    public BlankDisc(){}

    public BlankDisc(String name, int num){
        this.name = name;
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList(){
        return this.list;
    }


    public void play() {
        System.out.println(name + num);
        for(String content : list){
            System.out.println("内容是" + content);
        }
    }

    @Override
    public String toString() {
        return "BlankDisc{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", list=" + list +
                '}';
    }
}
