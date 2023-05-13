package ar.unrn.domain.model;

import java.util.List;

public interface Componente {

	List<Post> leerPosts();

	void guardarDatos() throws DomainExceptions;
}
