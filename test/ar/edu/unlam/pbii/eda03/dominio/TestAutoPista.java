package ar.edu.unlam.pbii.eda03.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista nuevo = new Autopista();
		assertTrue(nuevo.registrarTelepase((Integer)1, new Automovil("PFT-546", 120)));
	}

	@Test(expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista nuevo = new Autopista();
		Vehiculo coche =  new Automovil("PFT-546", 120);
		Vehiculo camion = new Camion("FRT-254", 65, 4);
		assertTrue(nuevo.registrarTelepase((Integer)1, coche));
		nuevo.ingresarAutopista(1);
		nuevo.salirAutpista(camion);
		
	}
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException{
		Autopista nuevo = new Autopista();
		Vehiculo coche =  new Automovil("PFT-546", 250);
		Vehiculo camion = new Camion("FRT-254", 100, 4);
		nuevo.registrarTelepase(1, coche);
		nuevo.registrarTelepase(2, camion);
		nuevo.ingresarAutopista(1);
		nuevo.ingresarAutopista(2);
		
		TreeSet<Vehiculo> vehiculosInsfractores = nuevo.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		assertEquals(2, vehiculosInsfractores.size());
		
		assertEquals("FRT-254", vehiculosInsfractores.first().getPatente());
		assertEquals("PFT-546", vehiculosInsfractores.last().getPatente());
	}
	
	@Test
	public void queIngreseUnVehiculoALaAutopista() throws VehiculoNotFounException {
		Autopista nuevo = new Autopista();
		Vehiculo coche =  new Automovil("PFT-546", 250);
		nuevo.registrarTelepase(1, coche);
		nuevo.ingresarAutopista(1);
		
		assertEquals(1, nuevo.cantidadDeVehiculosENCirculacion(),0.0);
	}
	
	@Test
	public void queRemuevaUnVehiculo() throws VehiculoNotFounException {
		Autopista nuevo = new Autopista();
		Vehiculo coche =  new Automovil("PFT-546", 120);
		nuevo.registrarTelepase((Integer)1, coche);
		nuevo.ingresarAutopista(1);
		nuevo.salirAutpista(coche);
		
		assertEquals(0, nuevo.cantidadDeVehiculosENCirculacion(), 0.0);
	}
	
}
