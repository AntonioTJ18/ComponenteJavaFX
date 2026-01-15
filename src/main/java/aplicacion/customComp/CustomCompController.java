package aplicacion.customComp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CustomCompController {

    @FXML
    private Button actionButton;

    @FXML
    private Label titleLabel;
    
    @FXML
    void cambiarTitulo(ActionEvent event) {
    	setTitle("Han pulsado el botón del componente");
    }
    
    // Métodos para personalizar el componente
    public void setTitle(String title) {
        titleLabel.setText(title);
    }

    public void setButtonText(String text) {
        actionButton.setText(text);
    }
}
