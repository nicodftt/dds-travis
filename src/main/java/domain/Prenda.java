package domain;

public class Prenda {

	private Tipo tipo;
	private Material material;
	private Color colorPrimario;
	private Color colorSecundario;

	public Prenda(Tipo tipo, Material material, Color colorPrimario, Color colorSecundario) {
		this.tipo = tipo;
		this.material = material;
		this.colorPrimario = colorPrimario;
		this.colorSecundario = colorSecundario;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public Categoria getCategoria() {
		return this.tipo.getCategoria();
	}

	public Material getMaterial() {
		return this.material;
	}

	public Color getColorPrimario() {
		return this.colorPrimario;
	}

	public Color getColorSecundario() {
		return this.colorSecundario;
	}

}
