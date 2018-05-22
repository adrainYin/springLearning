package ch01;

public class BraveKnight implements Knight{

    private Quest quest;
    private Minister minister;
    public BraveKnight(Quest quest, Minister minister){
        this.quest = quest;
        this.minister = minister;
    }
    @Override
    public void embarkQuest() {
        minister.before();
        quest.embark();
        minister.after();
    }
}
