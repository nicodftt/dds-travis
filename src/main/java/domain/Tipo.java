package domain;

import java.util.ArrayList;
import java.util.List;

public enum Tipo {

	ZAPATO {
		/* Se define el comportamiento de los enums para retornar la categoria */
		@Override
		public Categoria getCategoria() {
			return Categoria.CALZADO;
		}

		@Override
		public List<Material> materialesValidos() {
			lista.add(Material.CUERO);
			return lista;

		}
	},

	CAMISA_MANGAS_CORTAS {

		@Override
		public Categoria getCategoria() {
			return Categoria.PARTE_SUPERIOR;
		}

		@Override
		public List<Material> materialesValidos() {
			lista.add(Material.ALGODON);
			lista.add(Material.TELA);
			return lista;

		}
	},

	GORRA {

		@Override
		public Categoria getCategoria() {
			return Categoria.ACCESORIOS;
		}

		@Override
		public List<Material> materialesValidos() {
			lista.add(Material.LANA);
			return lista;

		}

	},

	REMERA {

		@Override
		public Categoria getCategoria() {
			return Categoria.PARTE_SUPERIOR;
		}

		@Override
		public List<Material> materialesValidos() {
			lista.add(Material.ALGODON);
			return lista;

		}

	},

	SHORT {

		@Override
		public Categoria getCategoria() {
			return Categoria.PARTE_INFERIOR;
		}

		@Override
		public List<Material> materialesValidos() {
			lista.add(Material.TELA);
			return lista;

		}

	},

	PANTALON {

		@Override
		public Categoria getCategoria() {
			return Categoria.PARTE_INFERIOR;
		};

		@Override
		public List<Material> materialesValidos() {
			lista.add(Material.TELA);
			return lista;

		}

	};

	public abstract Categoria getCategoria();

	public abstract List<Material> materialesValidos();

	List<Material> lista = new ArrayList<Material>();
}
