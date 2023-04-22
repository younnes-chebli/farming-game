package eu.epfc.anc3.model;

public class CabbageRotten implements State {
    private final Cabbage cabbage;
    private int LIFE_EXPECTANCY = 25;
    private final int LIFE_EXPECTANCY_GRASS = 15;
    private int daysFromRotten = 0;

    public CabbageRotten(Cabbage cabbage) {
        this.cabbage = cabbage;
        if(this.cabbage.hasGrass()) {
            LIFE_EXPECTANCY = LIFE_EXPECTANCY_GRASS;
        }
    }

    @Override
    public double grow(int day) {
        var current = cabbage.getLife();
        cabbage.setLife(++current);

        if(cabbage.getLife() >= cabbage.ROTTEN_DAY)
            ++daysFromRotten;

        if(cabbage.getLife() >= LIFE_EXPECTANCY) {
            return this.harvest(day);
        }

        return 0;
    }

    @Override
    public void fertilize() {
        LIFE_EXPECTANCY = LIFE_EXPECTANCY_GRASS;
    }

    @Override
    public double harvest(int day) {
        return -cabbage.COEFFICIENT * cabbage.MAXIMUM_PERFORMANCE* daysFromRotten;
    }
}
