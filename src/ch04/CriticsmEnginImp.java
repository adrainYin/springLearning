package ch04;

public class CriticsmEnginImp implements CriticismEngin{

    private String[] critismPool;

    public void setCritismPool(String[] critismPool) {
        this.critismPool = critismPool;
    }

    @Override
    public String getCritism() {
        int i = (int) Math.random() * critismPool.length;
        return critismPool[i];
    }
}
