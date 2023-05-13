package ar.unrn.domain.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EnBaseGuardarDatoDecoratorComponente extends GuardaDatoDecoratorComponente {

	private Propiedades properties;
	private String sqlInsertPost;

	public EnBaseGuardarDatoDecoratorComponente(Propiedades properties, String sqlInsertPost, Componente componente) {
		super(componente);
		this.properties = properties;
		this.sqlInsertPost = sqlInsertPost;
	}

	public void guardarDatos() throws DomainExceptions {

		componente.guardarDatos();

		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(sqlInsertPost)) {

			// CREA LA BASE Y SUBI LOS DATOS
			int cantidad = state.executeUpdate();

			if (cantidad <= 0) {
				throw new DomainExceptions("error al ingresar Post");
			}

		} catch (SQLException | NumberFormatException e) {
			throw new DomainExceptions("error al prosesar consulta");
		}

	}

}
