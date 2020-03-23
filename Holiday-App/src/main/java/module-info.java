module univ.stud {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires java.sql;

    opens univ.stud.holiday.gui to javafx.fxml, javafx.graphics;
    exports univ.stud.holiday.gui;
}