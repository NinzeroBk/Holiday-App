module univ.stud {
    requires org.jetbrains.annotations;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens univ.stud.holiday.gui.view to javafx.fxml, javafx.graphics;
    opens univ.stud.holiday.gui to javafx.fxml, javafx.graphics;

    exports univ.stud.holiday.test;
    exports univ.stud.holiday.gui;
}