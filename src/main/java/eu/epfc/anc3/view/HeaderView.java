package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.HeaderViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import static eu.epfc.anc3.view.FarmView.PADDING;

public class HeaderView extends HBox {
    private final Label scoreLabel = new Label("Score:");
    private final IntegerProperty score = new SimpleIntegerProperty(0);
    private final TextField scoreTextField = new TextField(score.asString().get());

    private final Label dayLabel = new Label("Jour:");
    private final IntegerProperty day = new SimpleIntegerProperty(1);
    private final TextField dayTextField = new TextField(day.asString().get());

    private final Label separation1 = new Label("|");
    private final Label separation2 = new Label("|");
    private final HeaderViewModel headerViewModel;

    public HeaderView(HeaderViewModel headerViewModel) {
        this.headerViewModel = headerViewModel;

        score.bind(headerViewModel.scoreProperty());
        score.addListener(e -> {
            scoreTextField.setText(score.asString().get());
        });

        day.bind(headerViewModel.dayProperty());
        day.addListener(e -> {
            dayTextField.setText(day.asString().get());
        });

        configHeader();
    }

    private void configHeader() {
        setPadding(new Insets(PADDING));
        setSpacing(10);
        scoreTextField.setDisable(true);
        scoreTextField.setPrefWidth(60);
        dayTextField.setDisable(true);
        dayTextField.setPrefWidth(30);
        getChildren().addAll(separation1, scoreLabel, scoreTextField, separation2, dayLabel, dayTextField);
    }
}
