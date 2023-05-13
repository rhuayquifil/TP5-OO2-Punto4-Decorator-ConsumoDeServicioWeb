package ar.unrn.main;

import ar.unrn.domain.model.BaseDeDatosPropiedades;
import ar.unrn.domain.model.Componente;
import ar.unrn.domain.model.DomainExceptions;
import ar.unrn.domain.model.EnBaseGuardarDatoDecoratorComponente;
import ar.unrn.domain.model.EnDiscoGuardaDatoDecoratorComponente;
import ar.unrn.domain.model.RestCallComponente;

public class Main {
	public static void main(String[] args) {
//		RestCallComponente rest = new RestCallComponente("https://jsonplaceholder.typicode.com/posts");
//		System.out.println(rest.run());

		Componente enDiscoGuardarDatos = new EnDiscoGuardaDatoDecoratorComponente(
				"C:\\Users\\ezehu\\git\\TP5-OO2-Punto4-Decorator-ConsumoDeServicioWeb\\data.txt", ", ",
				new RestCallComponente("https://jsonplaceholder.typicode.com/posts"));

		try {

			Componente enBaseGuardarDatos = new EnBaseGuardarDatoDecoratorComponente(
					new BaseDeDatosPropiedades("", "root", ""), "",
					new RestCallComponente("https://jsonplaceholder.typicode.com/posts"));

			enBaseGuardarDatos.guardarDatos();

		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		// TENES QUE HACER EL LEER DATOS EN RESTCALL Y LOS GUARDARDATOS
//		endisco(new RestCall("https://jsonplaceholder.typicode.com/posts"))
	}
}
