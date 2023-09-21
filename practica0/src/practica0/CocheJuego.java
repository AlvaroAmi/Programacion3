package practica0;

public class CocheJuego extends Coche {
	protected JLabelCoche labelcoche;
	

	public CocheJuego() {
		super();
		labelcoche = new JLabelCoche();
	}

	public JLabelCoche getLabelcoche() {
		return labelcoche;
	}

	public void setPosX(double posX) {
		this.posX += posX;
		labelcoche.setBounds((int)posX,(int)this.getPosY(),100,100);
	}
	
	public void setPosY(double posY) {
		this.posY += posY; 
		labelcoche.setBounds((int)this.getPosX(),(int)posY,100,100);
	}
	
	
	//En este caso he optado por utilizar unicamente el metodo mueve para desplazar el coche
	public void mueve(double tiempoDeMovimiento) {
		this.posX += this.getMiVelocidad() * tiempoDeMovimiento * Math.cos(Math.toRadians(miDireccionActual));
		this.posY += this.getMiVelocidad()* tiempoDeMovimiento * Math.sin(Math.toRadians(miDireccionActual));
		labelcoche.setBounds((int)posX,(int)posY,100,100);
		
	}
	
	
}
