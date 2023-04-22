package eu.epfc.anc3.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class Parcel {

    private final int line;
    private final int col;
    private final Field field;
    private final ObservableList<Item> itemsList = FXCollections.observableArrayList();

    Parcel(int line, int col, Field field) {
        this.line = line;
        this.col = col;
        this.field = field;
    }

    int getLine() {
        return line;
    }

    int getCol() {
        return col;
    }

    Parcel getDestination(int line, int col) {
        return field.getParcel(line, col);
    }

    void move(int line, int col) {
        if (isWalkable(line, col)) {
            removeItem(getFarmer());
        }
    }

    void removeItem(Item item) {
        if (item != null) {
            itemsList.remove(item);
        }
    }

    void addItem(Item item) {
        if (item != null) {
            itemsList.add(item);
        }
    }

    void removeAll() {
        itemsList.clear();
    }

    double grow(int day) {
        double res = 0;
        ObservableList<Item> toRemove = FXCollections.observableArrayList();

        for (Item item : itemsList) {
            if(item.isDead()) {
                res += item.harvest(day);
                toRemove.add(item);
            } else {
                item.grow(day);
            }
        }

        itemsList.removeAll(toRemove);
        return res;
    }

    boolean isWalkable(int line, int col) {
        return field.isWalkable(line, col);
    }

    boolean hasGrass() {
        for (Item item : itemsList) {
            if(item.isGrass())
                return true;
        }
        return false;
    }

    boolean hasCarrot() {
        for (Item item : itemsList) {
            if(item.isCarrot())
                return true;
        }
        return false;
    }

    boolean hasCabbage() {
        for (Item item : itemsList) {
            if(item.isCabbage())
                return true;
        }
        return false;
    }

    Vegetable getVegetable() {
        for (Item item : itemsList) {
            if(item.isVegetable())
                return (Vegetable)item;
        }
        return null;
    }

    Item getFarmer() {
        for (Item item : itemsList) {
            if(item.isFarmer())
                return item;
        }
        return null;
    }

    boolean hasVegetable() {
        for (Item item : itemsList) {
            if(item.isVegetable())
                return true;
        }
        return false;
    }

    private double harvest(Vegetable vegetable, int day) {
        if(vegetable != null) {
            double score = vegetable.harvest(day);
            itemsList.remove(vegetable);
            return score;
        }
        return 0;
    }

    double harvest(int day) {
        Vegetable vegetable;

        if(hasGrass() && hasCarrotOrCabbage()) {
            vegetable = getCarrotOrCabbage();
            return harvest(vegetable, day);
        }

        vegetable = getVegetable();
        return harvest(vegetable, day);
    }

    void fertilize() {
        if(hasVegetable()) {
            var carrot = (Carrot)getCarrot();
            carrot.getActualState().fertilize();
        }
    }

    void plantGrass(Grass grass) {
        if(!this.hasGrass()) {
            if(this.hasCabbage()) {
                getCabbage().fertilize();
            }
            this.addItem(grass);
        }
    }

    void plantCarrot(Carrot carrot) {
        if(hasNoCarrotAndNoCabbage()){
            this.addItem(carrot);
        }
    }

    void plantCabbage(Cabbage cabbage) {
        if(hasNoCarrotAndNoCabbage()){
            this.addItem(cabbage);
        }
    }

    private boolean hasNoCarrotAndNoCabbage() {
        return !this.hasCarrot() && !this.hasCabbage();
    }

    boolean hasCarrotOrCabbage() {
        return this.hasCarrot() || this.hasCabbage();
    }

    Vegetable getCarrotOrCabbage() {
        for (Item item : itemsList) {
            if(item.isCarrot() || item.isCabbage()) {
                return (Vegetable) item;
            }
        }

        return null;
    }

    Vegetable getCabbage() {
        for (Item item : itemsList) {
            if(item.isCabbage()) {
                return (Vegetable) item;
            }
        }

        return null;
    }

    Vegetable getCarrot() {
        for (Item item : itemsList) {
            if(item.isCarrot()) {
                return (Vegetable) item;
            }
        }

        return null;
    }

    SimpleListProperty<Item> itemListProperty() {
        return new SimpleListProperty<>(itemsList);
    }
}
