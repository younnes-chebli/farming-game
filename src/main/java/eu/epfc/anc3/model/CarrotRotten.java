package eu.epfc.anc3.model;

public class CarrotRotten implements State {
    private final Carrot carrot;
    private final int LIFE_EXPECTANCY = 23;
    private int daysFromRotten = 0;

    public CarrotRotten(Carrot carrot) {
        this.carrot = carrot;
    }

    @Override
    public double grow(int day) {
        var current = carrot.getLife();
        carrot.setLife(++current);

        if(carrot.getLife() >= carrot.ROTTEN_DAY)
            ++daysFromRotten;

        if(carrot.getLife() == LIFE_EXPECTANCY) {
            return this.harvest(day);
        }

        return 0;
    }

    @Override
    public void fertilize() {

    }

    @Override
    public double harvest(int day) {
        return -carrot.COEFFICIENT * carrot.MAXIMUM_PERFORMANCE* daysFromRotten;
    }
}
