package ar.unrn.main;

import ar.unrn.domain.model.Componente;
import ar.unrn.domain.model.EnDiscoGuardaDatoDecoratorComponente;
import ar.unrn.domain.model.RestCallComponente;

public class Main {
	public static void main(String[] args) {
//		RestCallComponente rest = new RestCallComponente("https://jsonplaceholder.typicode.com/posts");
//		System.out.println(rest.run());

		Componente enDiscoGuardarDatos = new EnDiscoGuardaDatoDecoratorComponente("",
				new RestCallComponente("https://jsonplaceholder.typicode.com/posts"));
		enDiscoGuardarDatos.guardarDatos();

//		Componente enBase = new EnBaseGuardarDatoDecoratorComponente(new EnDiscoGuardaDatoDecoratorComponente("",
//				new RestCallComponente("https://jsonplaceholder.typicode.com/posts")));
//		enBase.guardarDatos();
//		System.out.println(rest.leerDatos());
//		System.out.println(rest.run());

		// TENES QUE HACER EL LEER DATOS EN RESTCALL Y LOS GUARDARDATOS
//		endisco(new RestCall("https://jsonplaceholder.typicode.com/posts"))
	}
}
