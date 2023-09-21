package core;

import requests.*;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RemindBot extends TelegramLongPollingBot
{
    @Override
    public void onUpdateReceived(Update update)
    {
        RequestReader reader = new BotRequestReader();
        ResponseReplier replier = new BotResponseReplier();
        RequestHandler requestHandler = new SimpleRequestHandler();

        long chatId = update.getMessage().getChatId();

        Bucket request = reader.read(update);
        try
        {
            requestHandler.handle(request, replier);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Bucket response = requestHandler.getResponse();

        SendMessage newMessage = new SendMessage();
        newMessage.setChatId(chatId);
        newMessage.setText(replier.reply(response));

        try
        {
            execute(newMessage);
        }
        catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername()
    {
        return "ReminderAntoshkaBot";
    }

    @Override
    public String getBotToken()
    {
        return System.getenv("BOT_TOKEN");
    }
}
