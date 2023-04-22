package eu.epfc.anc3.model;

class Grass extends Vegetable {
    private int life = 1;

    Grass(Parcel parcel) {
        super(parcel);
        this.actualState = new GrassState(this);
        this.setActualStateEnum(ActualStateEnum.GRASS);
    }

    @Override
    public double harvest(int day) {
        return this.actualState.harvest(day);
    }

    @Override
    public boolean isGrass() {
        return true;
    }

    @Override
    public boolean isDead(){
        return  life == 12;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setActualState(State newActualState) {
        this.actualState = newActualState;
    }

    @Override
    public double grow(int day){
        return actualState.grow(day);
    }
}
