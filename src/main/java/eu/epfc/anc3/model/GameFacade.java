package eu.epfc.anc3.model;

import javafx.beans.property.*;

public class GameFacade {
    private final Field field;
    private final Farmer farmer;

    private final ObjectProperty<GameStatus> gameStatus = new SimpleObjectProperty<>(GameStatus.NOT_STARTED);
    private final BooleanProperty isStarted = new SimpleBooleanProperty(false);
    private final ObjectProperty<Mode> mode = new SimpleObjectProperty<>(Mode.NONE);
    private final IntegerProperty score = new SimpleIntegerProperty(0);
    private final IntegerProperty day = new SimpleIntegerProperty(0);

    public GameFacade() {
        field = new Field();
        farmer = new Farmer(field.getFirstParcel());
    }

    public void start() {
        gameStatus.set(GameStatus.STARTED);
        isStarted.set(true);

        field.removeAll();
        putFarmerAtInit();

        score.set(0);
        day.set(1);
    }

    public void sleep() {
        if(isStarted.get()) {
            int current = day.get();
            day.set(++current);

            var currentScore = this.score.get();
            currentScore += field.growAll(current);
            score.set(currentScore);
        }
    }

    public void harvest() {
        int current = score.get();
        current += farmer.harvest(current);
        score.set(current);
    }

    private void putFarmerAtInit() {
        farmer.getParcel().removeItem(farmer);
        farmer.setParcel(field.getFirstParcel());
        farmer.getParcel().addItem(farmer);
    }

    public void stop() {
        gameStatus.set(GameStatus.NOT_STARTED);

        isStarted.set(false);
        mode.set(Mode.NONE);
    }

    public void teleportFarmer(int line, int col) {
        farmer.teleport(line, col);
    }

    public void enablePlantingMode() {
        mode.set(Mode.PLANTING);
    }

    public void enablePlantingCarrotMode() {
        mode.set(Mode.PLANTING_CARROT);
    }

    public void enablePlantingCabbageMode() {
        mode.set(Mode.PLANTING_CABBAGE);
    }

    public void enableHarvestMode() {
        mode.set(Mode.HARVEST);
    }

    public void enableFertilizeMode() {
        mode.set(Mode.FERTILIZE);
    }

    public static int getFieldWidth() {
        return Field.FIELD_WIDTH;
    }

    public static int getFieldHeight() {
        return Field.FIELD_HEIGHT;
    }

    public GameStatus getGameStatus() {
        return gameStatus.get();
    }

    public void moveUp() {
        farmer.moveUp();
    }

    public void moveDown() {
        farmer.moveDown();
    }

    public void moveLeft() {
        farmer.moveLeft();
    }

    public void moveRight() {
        farmer.moveRight();
    }

    public void plantGrass() {
        farmer.plantGrass();
    }

    public void plantCarrot() {
        farmer.plantCarrot();
    }

    public void plantCabbage() {
        farmer.plantCabbage();
    }

    public void fertilize() {
        farmer.fertilize();
    }

    public SimpleListProperty<Item> itemListProperty(int line, int col) {
        return field.itemListProperty(line, col);
    }
    public ReadOnlyBooleanProperty isStartedProperty() {
        return isStarted;
    }
    public ReadOnlyObjectProperty<Mode> modeProperty() {
        return mode;
    }
    public ReadOnlyIntegerProperty scoreProperty() {
        return score;
    }
    public ReadOnlyIntegerProperty dayProperty() {
        return day;
    }
}
