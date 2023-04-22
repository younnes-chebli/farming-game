package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import javafx.beans.property.ReadOnlyBooleanProperty;

public class FooterViewModel {
    private final GameFacade gameFacade;

    public FooterViewModel(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    public void play() {
        gameFacade.start();
    }

    public void stop() {
        gameFacade.stop();
    }

    public void sleep() {
        gameFacade.sleep();
    }

    public void enablePlantingMode() {
        gameFacade.enablePlantingMode();
    }

    public void enablePlantingCarrotMode() {
        gameFacade.enablePlantingCarrotMode();
    }

    public void enablePlantingCabbageMode() {
        gameFacade.enablePlantingCabbageMode();
    }

    public void enableHarvestMode() {
        gameFacade.enableHarvestMode();
    }

    public void enableFertilizeMode() {
        gameFacade.enableFertilizeMode();
    }

    public ReadOnlyBooleanProperty isStartedProperty() {
        return gameFacade.isStartedProperty();
    }
}
