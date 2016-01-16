package code.springshape;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
class DrawEvent extends ApplicationEvent {

	public DrawEvent(Object source) {
		super(source);
		System.out.println("Draw Event called from " + source.toString());
	}

	@Override
	public String toString() {
		return "Draw Event Occurred";
	}

	
}
