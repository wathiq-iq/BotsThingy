package bots.examples.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTTP {

	public static HTTP requests = new HTTP();

	private HTTP() {}

	public String doRequest(String link) throws Exception {
		URL url = new URL(link);
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder str = new StringBuilder();

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			str.append(inputLine);
		in.close();
		return str.toString();
	}
}
