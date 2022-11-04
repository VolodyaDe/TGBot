package Console;

public class Main
{
    public static void main(String[] args)
    {
        RequestReader reader = new ConsoleRequestReader();
        ResponseReplier replier = new ConsoleResponseReplier();
        RequestHandler requestHandler = new SimpleRequestHandler();
        StopHandler stopHandler = new KeywordStopHandler("exit");

        while (true)
        {
            Request request = reader.read();
            if (stopHandler.needStop(request))
                break;

            Response response = requestHandler.handle(request);
            replier.reply(response);
        }
    }
}