package requests;

public interface RequestHandler
{
    void handle(Bucket request, ResponseReplier replier) throws InterruptedException;

    Bucket getResponse();
}
