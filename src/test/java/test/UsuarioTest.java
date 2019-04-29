package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Color;
import domain.Guardarropas;
import domain.Material;
import domain.Prenda;
import domain.Tipo;
import domain.Usuario;

public class UsuarioTest {

	private Usuario usuario = new Usuario();
	private Guardarropas guardarropa1 = new Guardarropas();
	private Guardarropas guardarropa2 = new Guardarropas();

	@Before
	public void setUp() {
		Prenda prenda1 = new Prenda(Tipo.ZAPATO, Material.TELA, Color.BLANCO, Color.ROJO);
		Prenda prenda2 = new Prenda(Tipo.REMERA, Material.TELA, Color.BLANCO, Color.ROJO);
		Prenda prenda3 = new Prenda(Tipo.SHORT, Material.TELA, Color.BLANCO, Color.ROJO);
		Prenda prenda4 = new Prenda(Tipo.GORRA, Material.TELA, Color.BLANCO, Color.ROJO);

		this.guardarropa1.setNuevaPrenda(prenda1);
		this.guardarropa1.setNuevaPrenda(prenda2);
		this.guardarropa1.setNuevaPrenda(prenda3);
		this.guardarropa1.setNuevaPrenda(prenda4);

		Prenda prenda5 = new Prenda(Tipo.ZAPATO, Material.TELA, Color.AZUL, Color.ROJO);
		Prenda prenda6 = new Prenda(Tipo.REMERA, Material.TELA, Color.AZUL, Color.ROJO);
		Prenda prenda7 = new Prenda(Tipo.SHORT, Material.TELA, Color.AZUL, Color.ROJO);
		Prenda prenda8 = new Prenda(Tipo.GORRA, Material.TELA, Color.AZUL, Color.ROJO);

		this.guardarropa2.setNuevaPrenda(prenda5);
		this.guardarropa2.setNuevaPrenda(prenda6);
		this.guardarropa2.setNuevaPrenda(prenda7);
		this.guardarropa2.setNuevaPrenda(prenda8);
	}

	@Test
	public void usuarioConDosGuardarropas() {
		this.usuario.agregarGuardarropa(guardarropa1);
		this.usuario.agregarGuardarropa(guardarropa2);
		Assert.assertEquals(this.usuario.cantidadDeGuardarropas(), 2);
	}

	@Test
	public void usuarioSinGuardarropas() {
		Assert.assertEquals(this.usuario.cantidadDeGuardarropas(), 0);
	}
	
	@Test
	public void usuarioObtenerSugerencias() {
		this.usuario.agregarGuardarropa(guardarropa1);
		this.usuario.agregarGuardarropa(guardarropa2);
		Assert.assertEquals(this.usuario.obtenerSugerencias().size(), 2);
	}
}
