package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Categoria;
import domain.Color;
import domain.Material;
import domain.Prenda;
import domain.PrendaBorrador;
import domain.PrendaInvalidaException;
import domain.Tipo;

public class CreacionPrendasTest {

	private PrendaBorrador borrador = new PrendaBorrador();
	private PrendaBorrador borradorMaterialInvalido = new PrendaBorrador();
	private PrendaBorrador borradorSinColorSecundario = new PrendaBorrador();
	private PrendaBorrador borradorAmbosColoresIguales = new PrendaBorrador();
	private PrendaBorrador borradorAtributosFaltantes = new PrendaBorrador();

	@Before
	public void setUp() {
		borrador.setTipo(Tipo.CAMISA_MANGAS_CORTAS);
		borrador.setMaterial(Material.TELA);
		borrador.setColorPrimario(Color.AZUL);
		borrador.setColorSecundario(Color.AMARILLO);

		borradorMaterialInvalido.setTipo(Tipo.CAMISA_MANGAS_CORTAS);
		borradorMaterialInvalido.setMaterial(Material.CUERO);
		borradorMaterialInvalido.setColorPrimario(Color.AZUL);
		borradorMaterialInvalido.setColorSecundario(Color.AMARILLO);
		
		borradorSinColorSecundario.setTipo(Tipo.GORRA);
		borradorSinColorSecundario.setMaterial(Material.LANA);
		borradorSinColorSecundario.setColorPrimario(Color.AZUL);
		
		borradorAmbosColoresIguales.setTipo(Tipo.CAMISA_MANGAS_CORTAS);
		borradorAmbosColoresIguales.setMaterial(Material.TELA);
		borradorAmbosColoresIguales.setColorPrimario(Color.AZUL);
		borradorAmbosColoresIguales.setColorSecundario(Color.AZUL);
		
		borradorAtributosFaltantes.setTipo(Tipo.CAMISA_MANGAS_CORTAS);
		borradorAtributosFaltantes.setMaterial(Material.TELA);
	}

	@Test
	public void borradorCreaPrendaConValoresEspecificados() {
		Prenda camisa = borrador.crearPrenda();
		
		Assert.assertEquals(Color.AZUL, camisa.getColorPrimario());
		Assert.assertEquals(Color.AMARILLO, camisa.getColorSecundario());
		Assert.assertEquals(Tipo.CAMISA_MANGAS_CORTAS, camisa.getTipo());
		Assert.assertEquals(Categoria.PARTE_SUPERIOR, camisa.getTipo().getCategoria());
	}

	@Test()
	public void puedeCrearPrendaSinColorSecundario() {
		Prenda prenda = borradorSinColorSecundario.crearPrenda();
		Assert.assertNull(prenda.getColorSecundario());
	}

	@Test(expected = PrendaInvalidaException.class)
	public void fallaPorTenerUnMaterialInvalido() {
		borradorMaterialInvalido.crearPrenda();
	}

	@Test(expected = PrendaInvalidaException.class)
	public void fallaPorTenerAmbosColoresIguales() {
		borradorAmbosColoresIguales.crearPrenda();
	}

	@Test(expected = PrendaInvalidaException.class)
	public void fallaPorAtributosFaltantes() {
		borradorAtributosFaltantes.crearPrenda();
	}
}
