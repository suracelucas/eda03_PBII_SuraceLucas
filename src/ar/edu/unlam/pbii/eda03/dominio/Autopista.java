package ar.edu.unlam.pbii.eda03.dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	public Autopista() {
		this.telepase = new HashMap<Integer, Vehiculo>();
		this.vehiculosEnCirculacion = new HashSet<Vehiculo>();
	}
	
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		telepase.put(numeroTelpase, vehiculo);
		return true;
	}
	
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException{
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista
		Vehiculo buscar = telepase.get(numeroTelepase);
		if( buscar == null) {
			throw new VehiculoNotFounException("No se encuentra el vehiculo.");
		}
		return vehiculosEnCirculacion.add(buscar);
	}
	
	public void salirAutpista (Vehiculo vehiculo)  throws VehiculoNotFounException{
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		if(vehiculosEnCirculacion.contains(vehiculo)) {
			vehiculosEnCirculacion.remove(vehiculo);
		}else{
			throw new VehiculoNotFounException("Vehiculo no encontrado.");
		}
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		TreeSet<Vehiculo> exceso = new TreeSet<Vehiculo>();
		for(Vehiculo nuevo : vehiculosEnCirculacion) {
			if(nuevo.enInfraccion()) {
				exceso.add(nuevo);
			}
		}
		return  exceso;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return this.vehiculosEnCirculacion.size();
	}
	
}
