package bots.examples;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import bots.examples.helpers.Statics;

public class LibExample extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {
		echo(update);
		print(update);
	}

	public void print(Update update) {
		System.out.println(update);
	}

	public void echo(Update update) {
		try {
			Message msg = update.getMessage();
			sendMessage(new SendMessage().setChatId(msg.getChatId()).setText(msg.getText()));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private String getUsername() {
		try {
			return getMe().getUserName();
		} catch (TelegramApiException e) {
			return "none";
		}
	}

	@Override
	public String getBotUsername() {
		return getUsername();
	}

	@Override
	public String getBotToken() {
		return Statics.token;
	}

	public static void main(String[] args) throws Exception {
		TelegramBotsApi api = new TelegramBotsApi();
		ApiContextInitializer.init();
		api.registerBot(new LibExample());
	}

}
