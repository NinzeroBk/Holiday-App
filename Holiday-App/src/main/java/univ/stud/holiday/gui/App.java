package univ.stud.holiday.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import univ.stud.holiday.gui.view.PersonEditDialogController;
import univ.stud.holiday.gui.view.PersonOverviewController;
import univ.stud.holiday.test.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * JavaFX App
 */
public class App extends Application {

    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private static BorderPane borderPane;
    private static Scene scene;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        initRootLayout(stage);
        showPersonOverview();
        fetchData();
    }

    private void fetchData() {
        new Thread(() -> {
            List<Person> personList = new ArrayList<>();

            personList.add(new Person("Hans", "Muster"));
            personList.add(new Person("Ruth", "Mueller"));
            personList.add(new Person("Heinz", "Kurz"));
            personList.add(new Person("Cornelia", "Meier"));
            personList.add(new Person("Werner", "Meyer"));
            personList.add(new Person("Lydia", "Kunz"));
            personList.add(new Person("Anna", "Best"));
            personList.add(new Person("Stefan", "Meier"));
            personList.add(new Person("Martin", "Mueller"));

            personList.forEach(person -> {
                personData.add(person);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }).start();
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    private static void initRootLayout(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("RootLayout.fxml"));
            borderPane = fxmlLoader.load();

            Scene scene = new Scene(borderPane);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPersonEditDialog(Person person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showPersonOverview() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PersonOverview.fxml"));
            borderPane.setCenter(fxmlLoader.load());

            PersonOverviewController controller = fxmlLoader.getController();
            controller.setApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Window getPrimaryStage() {
        return stage;
    }
}