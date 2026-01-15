package aplicacion.customComp;
	
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class CustomComp extends VBox {

	public CustomComp() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/aplicacion/customComp/CustomComp.fxml"));
        try {
        	loader.setRoot(this);
            loader.setController(new CustomCompController());
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el componente", e);
        }
	}
}
