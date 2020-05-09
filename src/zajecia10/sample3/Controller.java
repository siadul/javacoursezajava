package zajecia10.sample3;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label label1;

    @FXML
    private TextField textField1;

    @FXML
    private TextArea textArea1;

    @FXML
    private void initialize() {
//        StringBinding len = textArea1.textProperty().length().asString();
//        String text1 = textField1.textProperty().concat(len.);
//        label1.textProperty().bind(len.concat(text1));

        textField1.textProperty().addListener((observable, oldValue, newValue) -> {
            label1.setText(newValue + textArea1.getText().length());
        });

        textArea1.textProperty().addListener((observable, oldValue, newValue) -> {
//            label1.setText(newValue + textArea1.getText().length()); // nie zadziała
            // newValue tyczy się textArea1

            label1.setText(textField1.getText() + textArea1.getText().length());
        });
    }
}
