package ar.edu.unlam.pbii.eda03.dominio;



public  class Vehiculo implements Imultable, Comparable<Vehiculo>{

	//Se debe crear contructeres getters y Setters y loos que crean convenientes
	
	
	private String Patente;
	private Integer VelocidadActual;
	private Integer limiteVelocidad;

	public Vehiculo(String patente, Integer velocidadActual) {
		this.Patente = patente;
		this.VelocidadActual = velocidadActual;
	}
	
	public String getPatente() {
		return Patente;
	}

	public void setPatente(String patente) {
		Patente = patente;
	}

	public Integer getVelocidadActual() {
		return VelocidadActual;
	}


	public void setVelocidadActual(Integer velocidadActual) {
		VelocidadActual = velocidadActual;
	}


	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}


	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}



	public void incrmentarVelocidad(Integer Velocidad) {
		this.VelocidadActual += Velocidad;
	}
	
	@Override
	public Boolean enInfraccion() {
		if(this.getVelocidadActual() > this.getLimiteVelocidad()) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Vehiculo otroVehiculo) {
		
		return this.Patente.compareTo(otroVehiculo.Patente);
	}

	
}
