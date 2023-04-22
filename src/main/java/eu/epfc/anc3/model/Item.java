package eu.epfc.anc3.model;

public abstract class Item {
    private Parcel parcel;

    Item(Parcel parcel) {
        this.parcel = parcel;
    }

    Parcel getParcel() {
        return parcel;
    }

    void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public boolean isFarmer() {
        return false;
    }

    public boolean isGrass() {
        return false;
    }

    public boolean isVegetable() {
        return false;
    }

    public boolean isCarrot() {
        return false;
    }

    public boolean isCabbage() {
        return false;
    }

    public boolean isDead(){
        return false;
    }

    public double grow(int day) {
        return 0;
    }

    public double harvest(int day) {
        return 0;
    }
}
