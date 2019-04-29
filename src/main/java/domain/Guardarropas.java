package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

public class Guardarropas {

	List<Prenda> prendas = new ArrayList<Prenda>();

	public void setNuevaPrenda(Prenda _prenda) {
		this.prendas.add(_prenda);
	}

	public Set<Prenda> parteSuperiores() {
		return this.prendas.stream().filter(prenda -> prenda.getTipo().getCategoria() == Categoria.PARTE_SUPERIOR)
				.collect(Collectors.toSet());
	}

	public Set<Prenda> parteInferiores() {
		return this.prendas.stream().filter(prenda -> prenda.getTipo().getCategoria() == Categoria.PARTE_INFERIOR)
				.collect(Collectors.toSet());
	}

	public Set<Prenda> calzados() {
		return this.prendas.stream().filter(prenda -> prenda.getTipo().getCategoria() == Categoria.CALZADO)
				.collect(Collectors.toSet());
	}

	public Set<Prenda> accesorios() {
		return this.prendas.stream().filter(prenda -> prenda.getTipo().getCategoria() == Categoria.ACCESORIOS)
				.collect(Collectors.toSet());
	}

	public List<Atuendo> generarSugerencia() {
		return Sets.cartesianProduct(this.parteSuperiores(), this.parteInferiores(), this.calzados(), this.accesorios())
				.stream().map((list) -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3)))
				.collect(Collectors.toList());
	}
}
