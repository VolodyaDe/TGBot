import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        RequestReader reader = new BotRequestReader();
        ResponseReplier replier = new BotResponseReplier();
        RequestHandler requestHandler = new SimpleRequestHandler();

        long chatId = update.getMessage().getChatId();

        Request request = reader.read(update);
        Response response = requestHandler.handle(request);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(replier.reply(response));

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "ReminderAntoshkaBot";
    }

    @Override
    public String getBotToken() {
        return "5757484893:AAFECYiMdoaOhiCIrE-geW1iv70S1lSwRrM";
    }
}
