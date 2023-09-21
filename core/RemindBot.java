package core;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import userData.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RemindBot extends TelegramLongPollingBot
{
    private final UserMemoManager remindManager = new UserMemoManager();

    @Override
    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        remindManager.isUserExists(message.getChatId());
        SendMessage response = new SendMessage();
        response.setChatId(message.getChatId());

        if (message.getText().equals("/start"))
        {
            response.setText("Welcome\nIt's a primitive reminder bot\n\nEnter /help for more information");
            executeResponse(response);
        }

        else if (message.getText().equals("/help"))
        {
            response.setText("Format of the memo:\n\n1st str: *date* (dd.MM.yyyy HH:mm)\nother str: *text*");
            executeResponse(response);
        }

        else
        {
            int idx = message.getText().indexOf("\n");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date date;
            try
            {
                date = dateFormat.parse(message.getText().substring(0, idx));
            }
            catch (ParseException e)
            {
                response.setText("Incorrect date, try again");
                executeResponse(response);
                return;
            }

            UserMemo reminder = new UserMemo(message.getText().substring(idx + 1), date);
            remindManager.addMemoToUser(message.getChatId(), reminder);

            Thread thread = new Thread(() -> {
                Timer timer = new Timer();
                timer.schedule(new TimerTask()
                {
                    private boolean m_bIsRunning = true;

                    @Override
                    public void run()
                    {
                        if (reminder.dateCompare(new Date()) && m_bIsRunning)
                        {
                            response.setText(reminder.getMemoText());
                            executeResponse(response);
                            remindManager.removeMemoFromUser(message.getChatId(), reminder);
                            m_bIsRunning = false;
                        }
                    }
                }, 0, 1000);
            });
            thread.start();
        }
    }

    private void executeResponse(SendMessage response)
    {
        try
        {
            execute(response);
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
