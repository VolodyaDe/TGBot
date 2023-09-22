package requests;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BotRequestHandler implements RequestHandler
{
    @Override
    public void handle(Request request, ResponseReplier replier, SendMessage newMessage) throws InterruptedException {
        Response response;
        if (request.getMessage().equals("/start"))
            response = new Response("Welcome\nIt's a primitive reminder bot\n\nEnter /help for more information", request.getUserId());
        else if (request.getMessage().equals("/help"))
            response = new Response("Format of the memo:\n\n1st str: *date* (dd.MM.yyyy HH:mm)\nother str: *text*", request.getUserId());
        else
        {
            String requestMessage = request.getMessage();
            int idx = requestMessage.indexOf("\n");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date date;
            try
            {
                date = dateFormat.parse(requestMessage.substring(0, idx));
                Thread.sleep(date.getTime() - new Date().getTime());
                response = new Response(requestMessage.substring(idx + 1), request.getUserId());
            }
            catch (ParseException e)
            {
                response = new Response("Incorrect date, try again", request.getUserId());
            }
        }

        replier.reply(response, newMessage);
    }
}
