package eu.epfc.anc3.vm;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.model.GameStatus;

public class FarmViewModel {
    private final HeaderViewModel headerViewModel;
    private final FieldViewModel fieldViewModel;
    private final FooterViewModel footerViewModel;
    private final GameFacade gameFacade = new GameFacade();

    public HeaderViewModel getHeaderViewModel() {
        return headerViewModel;
    }

    public FieldViewModel getFieldViewModel() {
        return fieldViewModel;
    }

    public FooterViewModel getFooterViewModel() {
        return footerViewModel;
    }

    public FarmViewModel() {
        this.headerViewModel = new HeaderViewModel(gameFacade);
        this.fieldViewModel = new FieldViewModel(gameFacade);
        this.footerViewModel = new FooterViewModel(gameFacade);
    }

    public void moveUp() {
        if (gameFacade.getGameStatus() == GameStatus.STARTED) {
            gameFacade.moveUp();
        }
    }

    public void moveDown() {
        if (gameFacade.getGameStatus() == GameStatus.STARTED) {
            gameFacade.moveDown();
        }
    }

    public void moveLeft() {
        if (gameFacade.getGameStatus() == GameStatus.STARTED) {
            gameFacade.moveLeft();
        }
    }

    public void moveRight() {
        if (gameFacade.getGameStatus() == GameStatus.STARTED) {
            gameFacade.moveRight();
        }
    }

    public void actOnFarm() {
        switch (gameFacade.modeProperty().asString().get()) {
            case "PLANTING" -> gameFacade.plantGrass();
            case "PLANTING_CARROT" -> gameFacade.plantCarrot();
            case "PLANTING_CABBAGE" -> gameFacade.plantCabbage();
            case "HARVEST" -> gameFacade.harvest();
            case "FERTILIZE" -> gameFacade.fertilize();
        }
    }
}
