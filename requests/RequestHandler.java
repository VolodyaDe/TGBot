package requests;

public interface RequestHandler
{
    void handle(Request request, ResponseReplier replier) throws InterruptedException;
}
