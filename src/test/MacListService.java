package test;

public class MacListService implements ListService{
    @Override
    public String showListCmd() {
        return "我是mac并且我的查看是ls";
    }
}
