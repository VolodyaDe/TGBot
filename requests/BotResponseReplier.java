package requests;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class BotResponseReplier implements ResponseReplier
{
    private SendMessage newMessage;
    @Override
    public void reply(Response response)
    {
        newMessage = new SendMessage();
        newMessage.setChatId(response.getUserId());
        newMessage.setText(response.getMessage());
    }

    @Override
    public SendMessage getNewMessage()
    {
        return newMessage;
    }
}
