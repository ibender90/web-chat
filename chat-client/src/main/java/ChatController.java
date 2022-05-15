import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    private VBox mainPanel;
    @FXML
    public TextArea chatArea;
    @FXML
    public ListView contacts;
    @FXML
    public TextField inputField;
    @FXML
    public Button btnSend;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> names = List.of("Vasya", "Masha", "Petya", "Valera", "Nastya");
        contacts.setItems(FXCollections.observableList(names));
    }

    public void sendMessage(ActionEvent actionEvent) {
        String text = inputField.getText();
        if (text == null || text.isBlank()) {
            return;
        }
        chatArea.appendText(text + System.lineSeparator());
        inputField.clear();
    }

    public void closeApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void mockAction(ActionEvent actionEvent) {
        System.out.println("not finished");
    }
}
