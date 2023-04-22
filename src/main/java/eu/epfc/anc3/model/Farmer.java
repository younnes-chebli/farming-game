package eu.epfc.anc3.model;

class Farmer extends Item {
    Farmer(Parcel parcel) {
        super(parcel);
        parcel.addItem(this);
    }

    private void move(int line, int col) {
        getParcel().move(line, col);
        Parcel destination = getParcel().getDestination(line, col);
        if(destination != null) {
            destination.addItem(this);
            setParcel(destination);
        }
    }

    void moveUp() {
        move(getParcel().getLine() - 1, getParcel().getCol());
    }

    void moveDown() {
        move(getParcel().getLine() + 1, getParcel().getCol());
    }

    void moveLeft() {
        move(getParcel().getLine(), getParcel().getCol() - 1);
    }

    void moveRight() {
        move(getParcel().getLine(), getParcel().getCol() + 1);
    }

    void teleport(int line, int col) {
        move(line, col);
    }

    void plantGrass() {
        Grass grass = new Grass(getParcel());
        getParcel().plantGrass(grass);
    }

    void plantCarrot() {
        Carrot carrot = new Carrot(getParcel());
        getParcel().plantCarrot(carrot);
    }

    void plantCabbage() {
        Cabbage cabbage = new Cabbage(getParcel());
        getParcel().plantCabbage(cabbage);
    }

    public double harvest(int day) {
        return this.getParcel().harvest(day);
    }

    void fertilize() {
        getParcel().fertilize();
    }

    @Override
    public boolean isFarmer() {
        return true;
    }
}
