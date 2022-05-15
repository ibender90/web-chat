import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    private VBox mainPanel;
    @FXML
    private TextArea chatArea;
    @FXML
    private ListView contacts;
    @FXML
    private TextField inputField;
    @FXML
    private Button btnSend;

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
        chatArea.appendText(getPrefix() + ": " + text + System.lineSeparator());
        inputField.clear();
    }

    private String getPrefix(){
        if (getSelectedContactName() == null){
            return "Broadcast";
        } else return getSelectedContactName();
    }

    public String getSelectedContactName(){
        SelectionModel model = contacts.getSelectionModel(); //чем его правильно параметризировать ?
        return (String) model.getSelectedItem();
    }

    public void closeApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void mockAction(ActionEvent actionEvent) {
        System.out.println("not finished");
    }

    public void showHelp(ActionEvent actionEvent) { //простой вариант
        String FAQ = "http://github.com/ibender90/web-chat/blob/master/README.md"; // куда положить?
        try {
            Desktop.getDesktop().browse(new URL(FAQ).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
