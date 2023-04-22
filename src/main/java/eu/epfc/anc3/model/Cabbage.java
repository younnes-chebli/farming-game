package eu.epfc.anc3.model;

public class Cabbage extends Vegetable {
    private int life = 1;
    final int MAXIMUM_PERFORMANCE = 200;
    final int ROTTEN_DAY = 15;

    Cabbage(Parcel parcel) {
        super(parcel);
        this.actualState = new CabbageStateOne(this);
        this.setActualStateEnum(ActualStateEnum.CABBAGE_1);
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
    void fertilize() {
        this.actualState.fertilize();
    }

    @Override
    public double grow(int day){
        return actualState.grow(day);
    }

    public void setActualState(State newActualState) {
        this.actualState = newActualState;
    }

    @Override
    public boolean isCabbage() {
        return true;
    }

    @Override
    public boolean isDead() {
        if(this.actualStateEnumProperty().get() == ActualStateEnum.CABBAGE_ROTTEN && this.getParcel().hasGrass()) {
            return life == 16;
        }
        return life == 24;
    }
}
