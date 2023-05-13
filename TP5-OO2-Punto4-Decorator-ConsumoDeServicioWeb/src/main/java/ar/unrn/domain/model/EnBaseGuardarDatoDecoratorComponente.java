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

//			"INSERT INTO post (userId, id, title, body)" + "VALUES (?, ?, ?, ?);"

			for (Post post : super.leerPosts()) {
				state.setInt(1, Integer.valueOf(post.userId()));
				state.setInt(2, Integer.valueOf(post.id()));
				state.setString(3, post.title());
				state.setString(4, post.body());

				int cantidad = state.executeUpdate();

				if (cantidad <= 0) {
					throw new DomainExceptions("error al ingresar Post");
				}
			}
		} catch (SQLException e) {
			throw new DomainExceptions("error al prosesar consulta");
		}

	}

}
