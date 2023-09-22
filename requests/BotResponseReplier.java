package requests;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


public class BotResponseReplier implements ResponseReplier
{
    @Override
    public void reply(Response response, SendMessage newMessage)
    {
        newMessage.setChatId(response.getUserId());
        newMessage.setText(response.getMessage());
    }
}
