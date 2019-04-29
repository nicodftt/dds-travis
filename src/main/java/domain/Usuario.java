package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	List<Guardarropas> guardarropas = new ArrayList<Guardarropas>();

	public void agregarGuardarropa(Guardarropas guardarropa) {
		this.guardarropas.add(guardarropa);
	}

	public int cantidadDeGuardarropas() {
		return this.guardarropas.size();
	}
	
	public List<Atuendo> obtenerSugerencias() {
		return guardarropas.stream()
				.map(guardarropa -> 
				guardarropa.generarSugerencia()).flatMap(atuendo -> atuendo.stream()).collect(Collectors.toList());
	}
	
}
