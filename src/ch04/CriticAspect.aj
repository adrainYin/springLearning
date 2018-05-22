package ch04;


public aspect CriticAspect {

    public CriticAspect(){}

    pointcut performance() : execution(* ch04.Performance(..));

    after()returning() : performance() {
        System.out.println(criticismEngin.getCritism());
    }

    private CriticismEngin criticismEngin;
    public void setCriticismEngin(CriticismEngin criticismEngin) {
        this.criticismEngin = criticismEngin;
    }
}
