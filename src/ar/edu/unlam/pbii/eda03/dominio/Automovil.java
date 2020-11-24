package ar.edu.unlam.pbii.eda03.dominio;

public class Automovil extends Vehiculo {

	public Automovil(String patente, Integer velocidadActual) {
		super(patente, velocidadActual);
		this.setLimiteVelocidad(130);
	}

	//Si es necesario Utilice herencia o implemente de Interfaces
//	Se debe crear contructeres getters y Setters y loos que crean convenientes
	
//el Limite de velociadad para autos es de 130km
//en caso que supere dicho limite el este sera multado

	
	
   
	
}
