package exam.ex3;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML
    private Button btn1;

    @FXML
    private Slider sliderV;

    @FXML
    private Slider sliderH;

    @FXML
    private Pane pane1;

    @FXML
    private void initialize() {
        sliderH.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    double positionX = sliderH.getValue() * pane1.getPrefWidth() /
                            (sliderH.getMax() - sliderH.getMin());
                    btn1.setLayoutX(Math.min(pane1.getPrefWidth() - btn1.getWidth(), positionX));
                    btn1.setText(String.format("%.2f,%.2f", sliderH.getValue(), sliderV.getValue()));
                }
        );
        sliderV.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    double positionY = Math.min(-newValue.doubleValue() + pane1.getHeight(),
                            pane1.getHeight() - btn1.getHeight());
                    btn1.setLayoutY(positionY);
                    btn1.setText(String.format("%.2f,%.2f", sliderH.getValue(), sliderV.getValue()));
                }
        );
    }
}
