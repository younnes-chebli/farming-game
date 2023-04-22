package eu.epfc.anc3.model;

public class CarrotStateThree implements State {
    private final Carrot carrot;
    private final int LIFE_EXPECTANCY = 9;
    private final int score = 50;

    public CarrotStateThree(Carrot carrot) {
        this.carrot = carrot;
    }

    @Override
    public double grow(int day) {
        var current = carrot.getLife();
        carrot.setLife(++current);

        if(carrot.getLife() == LIFE_EXPECTANCY) {
            carrot.setActualState(new CarrotStateFour(carrot));
            carrot.setActualStateEnum(ActualStateEnum.CARROT_4);
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
