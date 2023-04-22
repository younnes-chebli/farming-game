package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import javafx.beans.property.ReadOnlyBooleanProperty;

public class FieldViewModel {
    private final GameFacade gameFacade;
    private ParcelViewModel parcelViewModel;

    public FieldViewModel(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    public ParcelViewModel getParcelViewModel(int line, int col) {
        this.parcelViewModel = new ParcelViewModel(line, col, gameFacade);
        return this.parcelViewModel;
    }

    public void teleportFarmer(int line, int col) {
        gameFacade.teleportFarmer(line, col);
    }

    public ReadOnlyBooleanProperty isStartedProperty() {
        return gameFacade.isStartedProperty();
    }
}
