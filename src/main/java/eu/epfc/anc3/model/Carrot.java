package eu.epfc.anc3.model;

public class Carrot extends Vegetable {
    private int life = 1;
    final int MAXIMUM_PERFORMANCE = 100;
    final int ROTTEN_DAY = 13;

    Carrot(Parcel parcel) {
        super(parcel);
        this.actualState = new CarrotStateOne(this);
        this.setActualStateEnum(ActualStateEnum.CARROT_1);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public double harvest(int day) {
        return this.actualState.harvest(day);
    }

    @Override
    public double grow(int day){
        return actualState.grow(day);
    }

    public void setActualState(State newActualState) {
        this.actualState = newActualState;
    }

    public State getActualState() {
        return actualState;
    }

    @Override
    public boolean isCarrot() {
        return true;
    }

    @Override
    public boolean isDead() {
        return life == 22;
    }
}
