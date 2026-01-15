import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javax.swing.text.Position;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.testfx.api.FxAssert.verifyThat;

public class ControladorTesteo extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) {
        try {
            VBox root = (VBox) FXMLLoader.load(getClass().getResource("/aplicacion/testComponente.fxml"));
            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            System.err.println(e.toString());
        }
    }
    @Test
    public void Verde_azulado()
    {

        clickOn("#rb_verde_azulado");
        Circle circulo = lookup("#circulo").queryAs(Circle.class);
        verifyThat(circulo.getFill(), is(Paint.valueOf("52FFCE")));
    }

    @Test
    public void Verde()
    {

        clickOn("#rb_verde");
        Circle circulo = lookup("#circulo").queryAs(Circle.class);
        verifyThat(circulo.getFill(), is(Paint.valueOf("C5FF8F")));
    }
    @Test
    public void Rosa()
    {

        clickOn("#rb_rosa");
        Circle circulo = lookup("#circulo").queryAs(Circle.class);
        verifyThat(circulo.getFill(), is(Paint.valueOf("FF8FD8")));
    }
    @Test
    public void Reinicio() {

        Circle circulo = lookup("#circulo").queryAs(Circle.class);

        // Guardar la posición inicial
        double initialX = circulo.getCenterX();
        double initialY = circulo.getCenterY();

        // Simular movimiento
        interact(() -> {
            circulo.setCenterX(initialX + 100);
            circulo.setCenterY(initialY + 50);
        });

        // Verificar que se movió
        verifyThat(circulo.getCenterX(), is(not(initialX)));
        verifyThat(circulo.getCenterY(), is(not(initialY)));

        // Click en Reiniciar
        clickOn("#btn_reiniciar");

        // Verificar que volvió a la posición inicial
        verifyThat(circulo.getCenterX(), is(initialX));
        verifyThat(circulo.getCenterY(), is(initialY));
    }


}
