package bryan.mod5labpt2;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;



public class HelloController {// instance variables for interacting with GUI components
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;


    public void initialize() {



        Bindings.bindBidirectional(redTextField.textProperty(), redSlider.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(greenTextField.textProperty(), greenSlider.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(blueTextField.textProperty(), blueSlider.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(alphaTextField.textProperty(), alphaSlider.valueProperty(), new NumberStringConverter());


        ChangeListener<Number> colorChangeListener = (observable, oldValue, newValue) -> {


            red = (int) redSlider.getValue();
            green = (int) greenSlider.getValue();
            blue = (int) blueSlider.getValue();
            alpha = alphaSlider.getValue();


            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        };


        redSlider.valueProperty().addListener(colorChangeListener);

        greenSlider.valueProperty().addListener(colorChangeListener);

        blueSlider.valueProperty().addListener(colorChangeListener);

        alphaSlider.valueProperty().addListener(colorChangeListener);


    }
}