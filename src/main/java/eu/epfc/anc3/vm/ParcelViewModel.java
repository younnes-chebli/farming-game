package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.Item;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;

public class ParcelViewModel {
    private final int line, col;
    private final GameFacade gameFacade;

    public ParcelViewModel(int line, int col, GameFacade gameFacade) {
        this.line = line;
        this.col = col;
        this.gameFacade = gameFacade;
    }

    public SimpleListProperty<Item> itemListProperty() {
        return gameFacade.itemListProperty(line, col);
    }
    public ReadOnlyIntegerProperty dayProperty() {
        return gameFacade.dayProperty();
    }
}
