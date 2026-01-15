package aplicacion.circulo;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.Random;



public class ComponenteJFXController {

    private final Random random = new Random();

    @FXML
    private Button reiniciar;

	@FXML
    private Circle circulo;

    @FXML
    private ToggleGroup colores;

    @FXML
    private RadioButton rb_verde_azulado;

    @FXML
    private RadioButton rb_verde;

    @FXML
    private RadioButton rb_rosa;

    private void limitarMovimiento() {
        double maxX = circulo.getParent().getLayoutBounds().getWidth() - circulo.getRadius() * 2;
        double maxY = circulo.getParent().getLayoutBounds().getHeight() - circulo.getRadius() * 2;

        if (circulo.getTranslateX() < 0) circulo.setTranslateX(0);
        if (circulo.getTranslateY() < 0) circulo.setTranslateY(0);
        if (circulo.getTranslateX() > maxX) circulo.setTranslateX(maxX);
        if (circulo.getTranslateY() > maxY) circulo.setTranslateY(maxY);
    }

    @FXML
    void reiniciarPosicion(ActionEvent event) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(400), circulo);
        tt.setToX(0);
        tt.setToY(0);
        tt.play();
    }


    @FXML
    void color_circle(ActionEvent event) {
        Paint pintura;

        if (rb_verde_azulado.isSelected()) pintura = Paint.valueOf("52FFCE");
        else if (rb_verde.isSelected()) pintura = Paint.valueOf("C5FF8F");
        else if (rb_rosa.isSelected()) pintura = Paint.valueOf("FF8FD8");
        else pintura = Paint.valueOf("FF8C52");

        circulo.setFill(pintura);
        circulo.fireEvent(new EventoCambioColor(pintura));

        double dx = random.nextDouble() * 200 - 100; // entre -100 y 100
        double dy = random.nextDouble() * 200 - 100;

        TranslateTransition tt = new TranslateTransition(Duration.millis(600), circulo);
        tt.setByX(dx);
        tt.setByY(dy);
        tt.play();

        limitarMovimiento();

        circulo.fireEvent(new EventoMoverCirculo());
    }


}
