package eu.epfc.anc3.model;

public class GrassState implements State {
    private final Grass grass;
    public final int LIFE_EXPECTANCY = 13;

    public GrassState(Grass grass) {
        this.grass = grass;
    }

    @Override
    public double grow(int day) {
        var current = grass.getLife();
        grass.setLife(++current);

        if(grass.getLife() == LIFE_EXPECTANCY) {
            return this.harvest(day);
        }

        return 0;
    }

    @Override
    public void fertilize() {

    }

    @Override
    public double harvest(int day) {
        return 0;
    }
}
