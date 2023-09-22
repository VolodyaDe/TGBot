package core;

import requests.*;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RemindBot extends TelegramLongPollingBot
{
    private final ResponseReplier replier;
    private final RequestHandler requestHandler;
    private final String botToken;
    public RemindBot()
    {
        replier = new BotResponseReplier();
        requestHandler = new BotRequestHandler();
        botToken = System.getenv("BOT_TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        Request request = prepareRequest(update);
        try
        {
            SendMessage newMessage = new SendMessage();
            requestHandler.handle(request, replier, newMessage);

            try
            {
                execute(newMessage);
            }
            catch (TelegramApiException e)
            {
                e.printStackTrace();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private Request prepareRequest(Update update)
    {
        Message message = update.getMessage();
        return new Request(message.getText(), message. getChatId());
    }

    @Override
    public String getBotUsername()
    {
        return "ReminderAntoshkaBot";
    }

    @Override
    public String getBotToken()
    {
        return botToken;
    }
}
