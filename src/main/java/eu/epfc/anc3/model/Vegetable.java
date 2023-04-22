package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class Vegetable extends Item {
    State actualState;
    private final ObjectProperty<ActualStateEnum> actualStateEnumProperty = new SimpleObjectProperty<>();
    double COEFFICIENT = 0.1;

    public ReadOnlyObjectProperty<ActualStateEnum> actualStateEnumProperty() {
        return actualStateEnumProperty;
    }

    public void setActualStateEnum(ActualStateEnum newActualStateEnum) {
        this.actualStateEnumProperty.set(newActualStateEnum);
    }

    Vegetable(Parcel parcel) {
        super(parcel);
    }

    public abstract double harvest(int day);

    void fertilize() {

    }

    boolean hasGrass() {
        return this.getParcel().hasGrass();
    }
    @Override
    public boolean isVegetable() {
        return true;
    }
}
