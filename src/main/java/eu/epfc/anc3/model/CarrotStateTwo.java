package eu.epfc.anc3.model;

public class CarrotStateTwo implements State {
    private final Carrot carrot;
    private final int LIFE_EXPECTANCY = 6;
    private final int score = 20;

    public CarrotStateTwo(Carrot carrot) {
        this.carrot = carrot;
    }

    private void nextState() {
        carrot.setActualState(new CarrotStateThree(carrot));
        carrot.setActualStateEnum(ActualStateEnum.CARROT_3);
    }

    @Override
    public double grow(int day) {
        var current = carrot.getLife();
        carrot.setLife(++current);

        if(carrot.getLife() == LIFE_EXPECTANCY) {
            nextState();
        }

        return 0;
    }

    @Override
    public void fertilize() {
        nextState();
    }

    @Override
    public double harvest(int day) {
        return score;
    }
}
