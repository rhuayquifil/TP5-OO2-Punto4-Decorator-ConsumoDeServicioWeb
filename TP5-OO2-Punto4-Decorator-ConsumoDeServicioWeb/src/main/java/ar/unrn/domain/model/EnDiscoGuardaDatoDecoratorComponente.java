package ar.unrn.domain.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EnDiscoGuardaDatoDecoratorComponente extends GuardaDatoDecoratorComponente {

	private String url;
	private String separador;

	public EnDiscoGuardaDatoDecoratorComponente(String url, String separador, Componente componente) {
		super(componente);
		this.url = url;
		this.separador = separador;
	}

	public void guardarDatos() throws DomainExceptions {

		componente.guardarDatos();

		try {
			FileWriter fileWriter = new FileWriter(url, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			escribirPostEnDisco(bufferedWriter);

			bufferedWriter.close();
		} catch (IOException e) {
			throw new RuntimeException("en disco guardarDatos");
		}

	}

	private void escribirPostEnDisco(BufferedWriter bufferedWriter) throws IOException {
		for (Post post : super.leerPosts()) {
			bufferedWriter
					.write(post.userId() + separador + post.id() + separador + post.title() + separador + post.body());
			bufferedWriter.newLine();
		}
	}

}
