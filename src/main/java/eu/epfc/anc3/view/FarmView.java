package eu.epfc.anc3.view;

import eu.epfc.anc3.model.GameFacade;
import eu.epfc.anc3.vm.FarmViewModel;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FarmView extends BorderPane {
    private final FarmViewModel farmViewModel = new FarmViewModel();

    private static final int SCENE_MIN_WIDTH = 800;
    private static final int SCENE_MIN_HEIGHT = 600;
    static final int PADDING = 20;
    static final int FIELD_WIDTH = GameFacade.getFieldWidth();
    static final int FIELD_HEIGHT = GameFacade.getFieldHeight();

    private HeaderView headerView;
    private FieldView fieldView;
    private FooterView footerView;

    public FarmView(Stage stage) {
        start(stage);
    }

    void start(Stage stage) {
        configMainComponents(stage);

        configScene(stage);

        configHandlers();
    }

    private void configMainComponents(Stage stage) {
        configHeader();

        configField();

        configFooter();
    }

    private void configHeader() {
        headerView = new HeaderView(farmViewModel.getHeaderViewModel());
        setTop(headerView);
    }

    private void configField() {
        fieldView = new FieldView(farmViewModel.getFieldViewModel());

        fieldView.setMinHeight(500);
        fieldView.setMinWidth(500);
        fieldView.setMaxHeight(500);
        fieldView.setMaxWidth(500);

        setLeft(fieldView);
    }

    private void configFooter() {
        footerView = new FooterView(this, farmViewModel.getFooterViewModel());
        setBottom(footerView);
    }

    private void configScene(Stage stage) {
        Scene scene = new Scene(this, SCENE_MIN_WIDTH, SCENE_MIN_HEIGHT);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Projet ANC3 2223 g02");
        stage.setMinHeight(stage.getHeight() + 50);
        stage.setMinWidth(stage.getWidth() + 100);
    }

    private void configHandlers() {
        setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D)) {
                farmViewModel.moveRight();
            }
            if (e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.Q)) {
                farmViewModel.moveLeft();
            }
            if (e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.Z)) {
                farmViewModel.moveUp();
            }
            if (e.getCode().equals(KeyCode.DOWN) || e.getCode().equals(KeyCode.S)) {
                farmViewModel.moveDown();
            }
            if (e.getCode().equals(KeyCode.SPACE)) {
                farmViewModel.actOnFarm();
            }
        });
    }
}
