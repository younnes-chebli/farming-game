package eu.epfc.anc3.model;

import javafx.beans.property.SimpleListProperty;

class Field {
    static final int FIELD_WIDTH = 15;
    static final int FIELD_HEIGHT = 25;

    private final Parcel[][] matrix;

    Field() {
        matrix = new Parcel[FIELD_WIDTH][];
        for (int i = 0; i < FIELD_WIDTH; ++i) {
            matrix[i] = new Parcel[FIELD_HEIGHT];
            for (int j = 0; j < FIELD_HEIGHT; ++j) {
                matrix[i][j] = new Parcel(i, j, this);
            }
        }
    }

    Parcel getFirstParcel() {
        return matrix[0][0];
    }

    boolean isWalkable(int line, int col) {
        return line >= 0 && line < FIELD_WIDTH && col >= 0 && col < FIELD_HEIGHT;
    }

    Parcel getParcel(int line, int col) {
        if(isWalkable(line, col))
            return matrix[line][col];
        return null;
    }

    void removeAll() {
        for (int i = 0; i < FIELD_WIDTH; ++i) {
            for (int j = 0; j < FIELD_HEIGHT; ++j) {
                matrix[i][j].removeAll();
            }
        }
    }

    double growAll(int day) {
        double res = 0;

        for (int i = 0; i < FIELD_WIDTH; ++i) {
            for (int j = 0; j < FIELD_HEIGHT; ++j) {
                res += matrix[i][j].grow(day);
            }
        }

        return res;
    }

    SimpleListProperty<Item> itemListProperty(int line, int col) {
        return matrix[line][col].itemListProperty();
    }

}
