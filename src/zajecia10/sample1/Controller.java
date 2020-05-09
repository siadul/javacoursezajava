package zajecia10.sample1;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Sphere;

public class Controller {
    public Button btn1;
    public Sphere sphere1;
    public Button btn2;

    public void btn1Action(ActionEvent actionEvent) {
        btn1.setText("Clicked!");
    }

    public void btn2Action(ActionEvent actionEvent) {
        sphere1.setTranslateX(150.);
    }
}
