package ar.unrn.domain.model;

import java.util.Objects;
import java.util.Properties;

public class BaseDeDatosPropiedades implements Propiedades {

	private Properties propiedades;

	public BaseDeDatosPropiedades(String urlBaseDeDatos, String usuario, String contrasena) throws DomainExceptions {

		if (Objects.isNull(urlBaseDeDatos)) {
			throw new DomainExceptions("Datos nulos urlBaseDeDatos BaseDeDatosPropiedades");
		}

		if (Objects.isNull(usuario)) {
			throw new DomainExceptions("Datos nulos usuario BaseDeDatosPropiedades");
		}

		if (Objects.isNull(contrasena)) {
			throw new DomainExceptions("Datos nulos contrasena BaseDeDatosPropiedades");
		}

		propiedades = new Properties();

		propiedades.put("url", urlBaseDeDatos);
		propiedades.put("usuario", usuario);
		propiedades.put("contrasena", contrasena);
	}

	public String get(String key) {
		return propiedades.getProperty(key);
	}
}
