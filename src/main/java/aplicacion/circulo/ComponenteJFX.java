package aplicacion.circulo;
	
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class ComponenteJFX extends Pane {
	
	private ComponenteJFXController controlador = new ComponenteJFXController();
	
	public ComponenteJFX() {
		try {
			FXMLLoader loader = new FXMLLoader();

            loader.setRoot(this);
			loader.setController(this.controlador);
			loader.setLocation(getClass().getResource("/aplicacion/circulo/ComponenteJFX.fxml"));
			loader.load();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
