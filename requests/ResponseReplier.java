package requests;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface ResponseReplier
{
    void reply(Response response);

    SendMessage getNewMessage();
}
