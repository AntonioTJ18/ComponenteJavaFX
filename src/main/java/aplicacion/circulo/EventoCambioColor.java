package aplicacion.circulo;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.paint.Paint;

public class EventoCambioColor extends Event {

	private static final long serialVersionUID = 1L;
	public static final EventType<EventoCambioColor> EVENTO_CAMBIOCOLOR = new EventType<>(Event.ANY, "EVENTO_CAMBIOCOLOR");
	private Paint pintura;
	
	public EventoCambioColor(Paint pintura) {
		super(EVENTO_CAMBIOCOLOR);
		this.pintura = pintura;
	}

	public Paint getPintura() {
		return this.pintura;
	}

}
