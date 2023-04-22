//ANC 2223 g02
module eu.epfc.anc3.anc3_oxo {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    opens eu.epfc.anc3.app to javafx.fxml;
    exports eu.epfc.anc3.app;
    exports eu.epfc.anc3.model;
    exports eu.epfc.anc3.vm;
}