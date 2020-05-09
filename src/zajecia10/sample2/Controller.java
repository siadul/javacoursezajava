package zajecia10.sample2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    private Button btn1;

    @FXML
    private Slider slider1;

    @FXML
    private Circle circle1;

    @FXML
    private Label label1;

    @FXML
    private Slider slider2;

    public void btn1Action(ActionEvent actionEvent) {
        Date date = new Date();
        System.out.println("Btn1 Action!!! " + date);
        slider1.setValue(0);
//        circle1.setTranslateX(0); // nie jest potrzebne set Value wywołuje zdarzenie valueChanged,
        // na który nasłuchuje listener utworzony w metodzie initialize. Listener ten zmieni
        // nam odpowiednio translację kształtu

        // efekt naciśnięcia
        btn1.setTranslateX(2);
        btn1.setTranslateY(2);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                btn1.setTranslateX(0);
                btn1.setTranslateY(0);
            }
        }, 200);
    }

    public void sliderDragged(MouseEvent mouseEvent) {
//        Date date = new Date();
//        System.out.println("Slider Dragged!!! " + date);
//        circle1.setTranslateX(slider1.getValue());

//        circle1.centerXProperty()
    }

    public void slider1DragDone(DragEvent dragEvent) {
//        Date date = new Date();
//        System.out.println("Slider DragDone Event!!! " + date);
//        circle1.setTranslateX(slider1.getValue());
    }

    public void slider1DragExited(DragEvent dragEvent) {
//        Date date = new Date();
//        System.out.println("Slider DragExited Event!!! " + date);
//        circle1.setTranslateX(slider1.getValue());
    }


    // Spostrzeżenie
    // Poniższe eventy nie działają "w czasie rzeczywistym", tzn. zmiana wartości suwaka powinna być
    // odnotowywana jeszcze przed zwolnieniem przycisku myszy!

    // Rozwiązanie - listenery


    /**
     *  Metoda initialize odpowiedzialna jest za inicjalizacje komponentów
     */
    @FXML
    private void initialize() {
        // Uwaga
        // Do inicjalizacji pól (np. przypisania listenerów) służy metoda initialize

        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            Date date = new Date();
            System.out.println("Listener! New Value: " + newValue + ", " + date);
            circle1.setTranslateX(slider1.getValue());
            // String format - budowanie ciągów znaków na podstawie zmiennych
            String value = String.format("%.2f", slider1.getValue()); // wyświetlanie dokładnie 2 miejsc po przecinku

            label1.setText(value);

            slider2.setValue(newValue.doubleValue());
//            slider1.setValue(slider2.getValue()); // nie zadziała, musimy dodać drugiego listenera
        });

        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            slider1.setValue(newValue.doubleValue());
        });

        // wiązania jedno- i dwukierunkowe
        // wiązania jednokierunkowe - gdy zmiana kontrolki A ma wpływ na kontrolkę B
        // wiązania dwukierunkowe - gdy zmiana kontrolki A ma wpływ na kontrolkę B, a zmiana
        // kontroli B ma wpływ na zmianę kontrolki A

        // Uwaga
        // Wiązania jedno i dwukierunkowe możemy stworzyć za pomocą listenerów
        // (najbardziej elastyczny sposób) lub przy pomocy
        // metod bind i bindBidirectional

//        slider1.valueProperty().bind(slider2.valueProperty()); // wiązanie jednokierunkowe
//        slider1.valueProperty().bindBidirectional(slider2.valueProperty()); // wiązanie dwukierunkowe
//        slider1.valueProperty().bind(slider2.valueProperty().multiply(10)); // wiązanie jednokierunkowe
        // z użyciem pomocniczych metod arytmetycznych



        // FXML - adnotacja, private initialize, private fields, load
        // Uwaga jeżeli nie chcemy żeby pole będące referencją do komponentu było publiczne to
        // wówczas musimy je oznaczyć adnotacją @FXML, tak aby loader wiedział, że ma je
        // zainicjalizować w metodzie load
    }

    public void btn1MouseEntered(MouseEvent mouseEvent) {
        btn1.setOpacity(0.5);
        btn1.setRotate(20);
    }

    public void btn1MouseExited(MouseEvent mouseEvent) {
        btn1.setOpacity(1);
        btn1.setRotate(0);
    }
}
