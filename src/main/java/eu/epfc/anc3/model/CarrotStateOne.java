package eu.epfc.anc3.model;

public class CarrotStateOne implements State {
    private final Carrot carrot;
    private final int LIFE_EXPECTANCY = 3;
    private final int score = 10;

    public CarrotStateOne(Carrot carrot) {
        this.carrot = carrot;
    }

    @Override
    public double grow(int day) {
        var current = carrot.getLife();
        carrot.setLife(++current);

        if(carrot.getLife() == LIFE_EXPECTANCY) {
            carrot.setActualState(new CarrotStateTwo(carrot));
            carrot.setActualStateEnum(ActualStateEnum.CARROT_2);
        }

        return 0;
    }

    @Override
    public void fertilize() {
        carrot.setActualState(new CarrotStateThree(carrot));
        carrot.setActualStateEnum(ActualStateEnum.CARROT_3);
    }

    @Override
    public double harvest(int day) {
        return score;
    }
}
