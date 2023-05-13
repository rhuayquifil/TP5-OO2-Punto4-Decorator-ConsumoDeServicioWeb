package ar.unrn.domain.model;

public class EnDiscoGuardaDatoDecoratorComponente extends GuardaDatoDecoratorComponente {

	private String url;

	public EnDiscoGuardaDatoDecoratorComponente(String url, Componente componente) {
		super(componente);
		this.url = url;
	}

	public void guardarDatos() {

		componente.guardarDatos();

		for (Post post : super.leerPosts()) {
			System.out.println(post);
		}
	}

}
