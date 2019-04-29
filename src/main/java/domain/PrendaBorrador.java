package domain;


public class PrendaBorrador {
	private Tipo tipo;
	private Material material;
	private Color colorPrimario;
	private Color colorSecundario;

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

	private boolean materialPrendaValido() {
		return this.tipo.materialesValidos().contains(this.material);
	}

	private boolean coloresDistintos() {
		return colorSecundario != colorPrimario;
	}

	private boolean valoresNoNulos() {
		return tipo != null && material != null && colorPrimario != null;
	}

	private void validarPrenda() {
		if (!(valoresNoNulos() && materialPrendaValido() && coloresDistintos()))
			throw new PrendaInvalidaException();
	}

	public Prenda crearPrenda() {
		validarPrenda();
		return new Prenda(this.tipo, this.material, this.colorPrimario, this.colorSecundario);
	}
}