package ar.unrn.domain.model;

import java.util.List;

public abstract class GuardaDatoDecoratorComponente implements Componente {

	protected Componente componente;

	public GuardaDatoDecoratorComponente(Componente componente) {
		super();
		this.componente = componente;
	}

	@Override
	public List<Post> leerPosts() {
		return componente.leerPosts();
	}

}
