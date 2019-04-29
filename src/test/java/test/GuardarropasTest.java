package test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Atuendo;
import domain.Color;
import domain.Guardarropas;
import domain.Material;
import domain.Prenda;
import domain.Tipo;

public class GuardarropasTest {

	private Guardarropas guardarropasUnaSolaCombinacion = new Guardarropas();
	private Guardarropas guardarropasMuchasCombinaciones = new Guardarropas();

	@Before
	public void setUp() {
		Prenda calzado1 = new Prenda(Tipo.ZAPATO, Material.TELA, Color.BLANCO, Color.ROJO);
		Prenda superior1 = new Prenda(Tipo.REMERA, Material.TELA, Color.BLANCO, Color.ROJO);
		Prenda superior2 = new Prenda(Tipo.CAMISA_MANGAS_CORTAS, Material.TELA, Color.BLANCO, Color.ROJO);
		Prenda inferior1 = new Prenda(Tipo.SHORT, Material.TELA, Color.BLANCO, Color.ROJO);
		Prenda inferior2 = new Prenda(Tipo.SHORT, Material.TELA, Color.BLANCO, Color.VERDE);
		Prenda accesorio1 = new Prenda(Tipo.GORRA, Material.TELA, Color.BLANCO, Color.ROJO);
		
		this.guardarropasMuchasCombinaciones.setNuevaPrenda(calzado1);
		this.guardarropasMuchasCombinaciones.setNuevaPrenda(superior1);
		this.guardarropasMuchasCombinaciones.setNuevaPrenda(superior2);
		this.guardarropasMuchasCombinaciones.setNuevaPrenda(inferior1);
		this.guardarropasMuchasCombinaciones.setNuevaPrenda(inferior2);
		this.guardarropasMuchasCombinaciones.setNuevaPrenda(accesorio1);

		Prenda calzadoA = new Prenda(Tipo.ZAPATO, Material.TELA, Color.AZUL, Color.ROJO);
		Prenda superiorA = new Prenda(Tipo.REMERA, Material.TELA, Color.AZUL, Color.ROJO);
		Prenda inferiorA = new Prenda(Tipo.SHORT, Material.TELA, Color.AZUL, Color.ROJO);
		Prenda accesorioA = new Prenda(Tipo.GORRA, Material.TELA, Color.AZUL, Color.ROJO);

		this.guardarropasUnaSolaCombinacion.setNuevaPrenda(calzadoA);
		this.guardarropasUnaSolaCombinacion.setNuevaPrenda(superiorA);
		this.guardarropasUnaSolaCombinacion.setNuevaPrenda(inferiorA);
		this.guardarropasUnaSolaCombinacion.setNuevaPrenda(accesorioA);
	}

	@Test
	public void muchasSugerenciasValidas() {
		List<Atuendo> sugerencias = this.guardarropasMuchasCombinaciones.generarSugerencia();
		Assert.assertEquals(sugerencias.size(), 4);
	}

	@Test
	public void soloUnaSugerencia() {
		List<Atuendo> sugerencias = this.guardarropasUnaSolaCombinacion.generarSugerencia();
		Assert.assertEquals(sugerencias.size(), 1);
	}
}
