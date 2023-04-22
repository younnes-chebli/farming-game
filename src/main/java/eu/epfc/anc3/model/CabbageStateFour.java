package eu.epfc.anc3.model;

public class CabbageStateFour implements State {
    private final Cabbage cabbage;
    private int LIFE_EXPECTANCY = 14;
    private final int LIFE_EXPECTANCY_GRASS = 10;
    private final int score = 200;

    public CabbageStateFour(Cabbage cabbage) {
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
            cabbage.setActualState(new CabbageRotten(cabbage));
            cabbage.setActualStateEnum(ActualStateEnum.CABBAGE_ROTTEN);
        }

        return 0;
    }

    @Override
    public void fertilize() {
        LIFE_EXPECTANCY = LIFE_EXPECTANCY_GRASS;
    }

    @Override
    public double harvest(int day) {
        return score;
    }
}
