package eu.epfc.anc3.model;

public class CabbageStateOne implements State {
    private final Cabbage cabbage;
    private int LIFE_EXPECTANCY = 5;
    private final int LIFE_EXPECTANCY_GRASS = 4;

    public CabbageStateOne(Cabbage cabbage) {
        this.cabbage = cabbage;
        if(this.cabbage.hasGrass()) {
            LIFE_EXPECTANCY = LIFE_EXPECTANCY_GRASS;
        }
    }

    @Override
    public double grow(int day) {
        var current = cabbage.getLife();
        cabbage.setLife(++current);

        if(cabbage.getLife() >= LIFE_EXPECTANCY) {
            cabbage.setActualState(new CabbageStateTwo(cabbage));
            cabbage.setActualStateEnum(ActualStateEnum.CABBAGE_2);
        }

        return 0;
    }

    @Override
    public void fertilize() {
        LIFE_EXPECTANCY = LIFE_EXPECTANCY_GRASS;
    }

    @Override
    public double harvest(int day) {
        return 0;
    }
}
