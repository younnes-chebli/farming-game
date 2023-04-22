package eu.epfc.anc3.view;

import eu.epfc.anc3.vm.FieldViewModel;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static eu.epfc.anc3.view.FarmView.*;

public class FieldView extends GridPane {
    private ParcelView parcelView;

    public FieldView(FieldViewModel fieldViewModel) {
        this.requestFocus();
        //setGridLinesVisible(true);
        setPadding(new Insets(PADDING));

        for (int i = 0; i < FIELD_WIDTH; ++i) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPrefHeight(50);
            getRowConstraints().add(rowConstraints);
            for (int j = 0; j < FIELD_HEIGHT; ++j) {
                ColumnConstraints colConstraints = new ColumnConstraints();
                colConstraints.setPrefWidth(50);
                getColumnConstraints().add(colConstraints);
                parcelView = new ParcelView(fieldViewModel.getParcelViewModel(i, j));
                add(parcelView, j, i);
                int line = i;
                int col = j;
                parcelView.setOnMouseClicked(e -> {
                    if(fieldViewModel.isStartedProperty().get()) {
                        fieldViewModel.teleportFarmer(line, col);
                    }
                });
            }
        }
    }
}
