package requests;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface RequestHandler
{
    void handle(Request request, ResponseReplier replier, SendMessage newMessage) throws InterruptedException;
}
