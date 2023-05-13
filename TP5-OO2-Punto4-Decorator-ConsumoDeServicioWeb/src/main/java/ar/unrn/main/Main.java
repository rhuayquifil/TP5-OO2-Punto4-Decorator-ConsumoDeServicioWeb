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
					new BaseDeDatosPropiedades("jdbc:mysql://127.0.0.1/tp5_consumodeservicioweb", "root", ""),
					"INSERT INTO post (userId, id, title, body)" + "VALUES (?, ?, ?, ?);",
					new RestCallComponente("https://jsonplaceholder.typicode.com/posts"));

			Componente dosVecesEnDiscoConDistintoFormatoYUnaEnBase = new EnDiscoGuardaDatoDecoratorComponente(
					"C:\\Users\\ezehu\\git\\TP5-OO2-Punto4-Decorator-ConsumoDeServicioWeb\\data.txt", ", ",
					new EnBaseGuardarDatoDecoratorComponente(
							new BaseDeDatosPropiedades("jdbc:mysql://127.0.0.1/tp5_consumodeservicioweb", "root", ""),
							"INSERT INTO post (userId, id, title, body)" + "VALUES (?, ?, ?, ?);",
							new EnDiscoGuardaDatoDecoratorComponente(
									"C:\\Users\\ezehu\\git\\TP5-OO2-Punto4-Decorator-ConsumoDeServicioWeb\\data.txt",
									" || ", new RestCallComponente("https://jsonplaceholder.typicode.com/posts"))));

			dosVecesEnDiscoConDistintoFormatoYUnaEnBase.guardarDatos();
			System.out.println("se guardaron los datos");

		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
	}
}
