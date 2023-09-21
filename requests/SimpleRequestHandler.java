package requests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SimpleRequestHandler implements RequestHandler
{
    private Bucket response;
    private final Timer timer = new Timer();

    @Override
    public void handle(Bucket request, ResponseReplier replier) throws InterruptedException {
        if (replier.reply(request).equals("/start"))
            response = new Bucket("Welcome\nIt's a primitive reminder bot\n\nEnter /help for more information");
        else if (replier.reply(request).equals("/help"))
            response = new Bucket("Format of the memo:\n\n1st str: *date* (dd.MM.yyyy HH:mm)\nother str: *text*");
        else
        {
            String requestMessage = replier.reply(request);
            int idx = requestMessage.indexOf("\n");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date date;
            try
            {
                date = dateFormat.parse(requestMessage.substring(0, idx));
            }
            catch (ParseException e)
            {
                response = new Bucket("Incorrect date, try again");
                return;
            }

            Thread.sleep(date.getTime() - new Date().getTime());
            response = new Bucket(requestMessage.substring(idx + 1));

            /*
            timer.schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    response = new Bucket(requestMessage.substring(idx + 1));
                }
            }, date);
             */
        }
    }

    @Override
    public Bucket getResponse()
    {
        return response;
    }
}
