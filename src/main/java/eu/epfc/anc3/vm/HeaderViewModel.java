package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class HeaderViewModel {
    private final GameFacade gameFacade;

    private final IntegerProperty score = new SimpleIntegerProperty(0);
    private final IntegerProperty day = new SimpleIntegerProperty(0);

    public HeaderViewModel(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
        score.bind(gameFacade.scoreProperty());
        day.bind(gameFacade.dayProperty());
    }

    public ReadOnlyIntegerProperty scoreProperty() {
        return score;
    }
    public ReadOnlyIntegerProperty dayProperty() {
        return day;
    }
}
