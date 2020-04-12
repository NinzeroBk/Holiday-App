package univ.stud.holiday.gui.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import univ.stud.holiday.gui.App;
import univ.stud.holiday.test.Person;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the app
    private App app;

    // No-args Constructor
    public PersonOverviewController() {
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // Clear data
        showPersonDetails(null);

        // Listen to selection changes
        personTableView
                .getSelectionModel()
                .selectedItemProperty()
                .addListener((observableValue, person, t1) -> showPersonDetails(t1));
    }

    public void setApp(App app) {
        this.app = app;
        personTableView.setItems(app.getPersonData());
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            postalCodeLabel.setText(String.valueOf(person.getPostalCode()));
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            cityLabel.setText(person.getCity());
        } else {
            postalCodeLabel.setText("");
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            birthdayLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
        }
    }

    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = app.showPersonEditDialog(tempPerson);
        if (okClicked) {
            app.getPersonData().add(tempPerson);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTableView.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = app.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(app.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(app.getPrimaryStage());
            alert.initModality(Modality.WINDOW_MODAL);
            alert.setTitle("No selection");
            alert.setHeaderText("No Person is selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        } else {
            personTableView.getItems().remove(selectedIndex);
        }
    }
}
