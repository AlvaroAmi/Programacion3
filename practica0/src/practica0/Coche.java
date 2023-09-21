package practica0;

public class Coche {
	private double miVelocidad; // Velocidad en pixels/segundo
	protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360)
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)
	private String piloto; // Nombre de piloto
	
	
	public Coche() { //Constructor para iniciar todo a cero
		super();
		this.miVelocidad = 0;
		this.miDireccionActual = 0;
		this.posX = 0;
		this.posY = 0;
		this.piloto = "";}

	//GETTERS Y SETTERS
	
	public double getMiVelocidad() {
		return miVelocidad;	}

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad; }

	public double getMiDireccionActual() {
		return miDireccionActual; }

	public void setMiDireccionActual(double miDireccionActual) {
	if (miDireccionActual > 360) {
		miDireccionActual = miDireccionActual - 360;
	}
	if(miDireccionActual < 0) {
		miDireccionActual = miDireccionActual + 360;
	}
	this.miDireccionActual = miDireccionActual;
	
	}

	public double getPosX() {
		return posX; }

	public void setPosX(double posX) {
		this.posX = posX; }

	public double getPosY() {
		return posY; }

	public void setPosY(double posY) {
		this.posY = posY; }

	public String getPiloto() {
		return piloto; }

	public void setPiloto(String piloto) {
		this.piloto = piloto; }


	@Override
	public String toString() {
		return "Velocidad: " + miVelocidad + " dirección: " + miDireccionActual + " x: " + posX
				+ " y: " + posY + " piloto: " + piloto; }

	
	public void acelera(double aceleracion) {
		this.setMiVelocidad(miVelocidad+aceleracion);
	}
	
	public void gira(double giro) {
		this.setMiDireccionActual(miDireccionActual+giro);
	}
	
	public void mueve(double tiempoDeMovimiento) {
		this.setPosX(miVelocidad * tiempoDeMovimiento * Math.cos(Math.toRadians(miDireccionActual)));
		this.setPosY(miVelocidad * tiempoDeMovimiento * Math.sin(Math.toRadians(miDireccionActual)));
		
	}
	
	
	
	
}
