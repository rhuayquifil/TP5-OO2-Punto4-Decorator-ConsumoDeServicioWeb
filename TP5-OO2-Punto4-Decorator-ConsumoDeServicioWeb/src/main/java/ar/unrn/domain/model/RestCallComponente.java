package ar.unrn.domain.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RestCallComponente implements Componente {
	private String url;

	public RestCallComponente(String url) {
		this.url = url;
	}

//	public String run() {
//		OkHttpClient client = new OkHttpClient();
//		Request request = new Request.Builder().url(this.url).build();
//		try (Response response = client.newCall(request).execute()) {
//			return response.body().string();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	public List<Post> leerPosts() {
		List<Post> listaDePost = new ArrayList<Post>();

		List<String> data = leerDatos();
		for (int i = 0; i < data.size(); i += 4) {
			listaDePost.add(new Post(data.get(i), data.get(i + 1), data.get(i + 2), data.get(i + 3)));
		}
		return listaDePost;
	}

	private List<String> leerDatos() {
		List<String> data = new ArrayList<String>();

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(this.url).build();

		try (Response response = client.newCall(request).execute()) {

			ResponseBody responseBody = response.body();

			completarData(data, responseBody);

		} catch (IOException | IllegalStateException e) {
			throw new RuntimeException(e);
		}
		return data;
	}

	private void completarData(List<String> data, ResponseBody responseBody) {
		Scanner scanner = new Scanner(responseBody.byteStream()).useDelimiter("\\A");
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().replaceAll("[{}\\[\\],\"]", "").replaceAll("userId: ", "")
					.replaceAll("id: ", "").replaceAll("title: ", "").replaceAll("body: ", "").trim();

			if (!line.isEmpty()) {
				data.add(line);
			}
		}
	}

	@Override
	public void guardarDatos() {
	}

}
