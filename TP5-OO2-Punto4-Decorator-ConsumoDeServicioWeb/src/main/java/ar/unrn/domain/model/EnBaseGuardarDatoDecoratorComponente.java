package ar.unrn.domain.model;

public class EnBaseGuardarDatoDecoratorComponente extends GuardaDatoDecoratorComponente {

	public EnBaseGuardarDatoDecoratorComponente(Componente componente) {
		super(componente);
	}

	public void guardarDatos() {
		componente.guardarDatos();
		System.out.println("guardar en base");

	}

}
