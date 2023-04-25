package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.FooterViewModel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import static eu.epfc.anc3.view.FarmView.PADDING;

public class FooterView extends HBox {
    private final Button startButton = new Button("Démarrer");
    private final Button stopButton = new Button("Arrêter");
    private final Button sleepButton = new Button("Dormir");
    private final ImageView grassImage = new ImageView(new Image("grass.png"));
    private final ImageView carrotImage = new ImageView(new Image("carrot4.png"));
    private final ImageView cabbageImage = new ImageView(new Image("cabbage4.png"));
    private final ImageView fertilizeImage = new ImageView(new Image("watering_can.png"));
    private final ImageView harvestImage = new ImageView(new Image("shovel.png"));
    private final ToggleButton plantGrassButton = new ToggleButton("Planter du gazon", grassImage);
    private final ToggleButton plantCarrotButton = new ToggleButton("Planter des carottes", carrotImage);
    private final ToggleButton plantCabbageButton = new ToggleButton("Planter des choux", cabbageImage);
    private final ToggleButton fertilizeButton = new ToggleButton("Fertiliser", fertilizeImage);
    private final ToggleButton harvestButton = new ToggleButton("Récolter", harvestImage);
    private final ToggleGroup toggleGroup = new ToggleGroup();

    private final FarmView farmview;
    private final FooterViewModel footerViewModel;

    public FooterView(FarmView farmView, FooterViewModel footerViewModel) {
        this.farmview = farmView;
        this.footerViewModel = footerViewModel;
        configMenu();
        configBindings();
        configHandlers();
    }

    private void configBindings() {
        startButton.visibleProperty().bind(footerViewModel.isStartedProperty().not());
        startButton.setFocusTraversable(false);
        stopButton.visibleProperty().bind(footerViewModel.isStartedProperty());
        stopButton.focusedProperty().addListener(e -> {
            farmview.requestFocus();
        });

        sleepButton.disableProperty().bind(footerViewModel.isStartedProperty().not());
        sleepButton.focusedProperty().addListener(e -> {
            farmview.requestFocus();
        });

        for (Toggle toggle : toggleGroup.getToggles()) {
            ToggleButton toggleButton = (ToggleButton) toggle;

            toggleButton.focusedProperty().addListener(e -> {
                farmview.requestFocus();
            });

//            toggleButton.visibleProperty().bind(footerViewModel.isStartedProperty());
            toggleButton.disableProperty().bind(footerViewModel.isStartedProperty().not());
        }
    }

    private void configMenu() {
        setPadding(new Insets(PADDING));
        setSpacing(15);
        plantGrassButton.setToggleGroup(toggleGroup);
        plantCarrotButton.setToggleGroup(toggleGroup);
        plantCabbageButton.setToggleGroup(toggleGroup);
        fertilizeButton.setToggleGroup(toggleGroup);
        harvestButton.setToggleGroup(toggleGroup);
        getChildren().addAll(stopButton, startButton, sleepButton, plantGrassButton, plantCarrotButton, plantCabbageButton, fertilizeButton, harvestButton);
    }

    private void configHandlers() {
        startButton.setOnAction(e -> {
            footerViewModel.play();
            toggleGroup.selectToggle(null);
            farmview.requestFocus();
        });

        stopButton.setOnAction(e -> {
            footerViewModel.stop();
        });

        sleepButton.setOnAction(e -> {
            footerViewModel.sleep();
            farmview.requestFocus();
        });

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == plantGrassButton) {
                footerViewModel.enablePlantingMode();
            } else if (newValue == plantCarrotButton) {
                footerViewModel.enablePlantingCarrotMode();
            } else if (newValue == plantCabbageButton) {
                footerViewModel.enablePlantingCabbageMode();
            } else if (newValue == fertilizeButton) {
                footerViewModel.enableFertilizeMode();
            } else if (newValue == harvestButton) {
                footerViewModel.enableHarvestMode();
            }
        });
    }
}
