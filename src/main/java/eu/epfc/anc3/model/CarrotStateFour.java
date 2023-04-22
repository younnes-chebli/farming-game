package eu.epfc.anc3.model;

public class CarrotStateFour implements State {
    private final Carrot carrot;
    private final int LIFE_EXPECTANCY = 12;
    private final int score = 100;

    public CarrotStateFour(Carrot carrot) {
        this.carrot = carrot;
    }

    @Override
    public double grow(int day) {
        var current = carrot.getLife();
        carrot.setLife(++current);

        if(carrot.getLife() == LIFE_EXPECTANCY) {
            carrot.setActualState(new CarrotRotten(carrot));
            carrot.setActualStateEnum(ActualStateEnum.CARROT_ROTTEN);
        }

        return 0;
    }

    @Override
    public void fertilize() {

    }

    @Override
    public double harvest(int day) {
        return score;
    }
}
