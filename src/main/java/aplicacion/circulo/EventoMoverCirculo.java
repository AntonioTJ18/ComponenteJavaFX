package aplicacion.circulo;

import javafx.event.Event;
import javafx.event.EventType;

public class EventoMoverCirculo extends Event {

    private static final long serialVersionUID = 1L;

    public static final EventType<EventoMoverCirculo> EVENTO_MOVER_CIRCULO =
            new EventType<>(Event.ANY, "EVENTO_MOVER_CIRCULO");

    public EventoMoverCirculo() {
        super(EVENTO_MOVER_CIRCULO);
    }
}
