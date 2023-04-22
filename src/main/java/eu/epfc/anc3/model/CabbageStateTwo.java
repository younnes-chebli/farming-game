package eu.epfc.anc3.model;

public class CabbageStateTwo implements State {
    private final Cabbage cabbage;
    private int LIFE_EXPECTANCY = 9;
    private final int LIFE_EXPECTANCY_GRASS = 7;

    public CabbageStateTwo(Cabbage cabbage) {
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
            cabbage.setActualState(new CabbageStateThree(cabbage));
            cabbage.setActualStateEnum(ActualStateEnum.CABBAGE_3);
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
