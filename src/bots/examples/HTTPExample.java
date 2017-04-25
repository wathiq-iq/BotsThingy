package bots.examples;

import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bots.examples.helpers.HTTP;
import bots.examples.helpers.Statics;

public class HTTPExample {

	static String res;

	static String request() throws Exception {
		if (res == null)
			res = HTTP.requests.doRequest(Statics.tgServer + Statics.token + "/getMe");
		return res;
	}

	static void normalRequest() throws Exception {
		System.out.println(request());
	}

	static void formattedRequest() throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JSONObject obj = (JSONObject) new JSONParser().parse(request());
		System.out.println(gson.toJson(obj));
	}

	static void sendMessage(String chat_id, String text) throws Exception {
		HTTP.requests.doRequest(Statics.base + "sendMessage?chat_id=" + chat_id + "&text=" + URLEncoder.encode(text, "UTF-8"));
	}

	public static void main(String[] args) throws Exception {
		// normalRequest();
		// formattedRequest();
		// sendMessage("121414901", "Hello");
	}

}
