import org.telegram.telegrambots.meta.api.objects.Update;

public class BotRequestReader implements RequestReader {

    @Override
    public Request read(Update update)
    {
        String text = update.getMessage().getText();
        return new Request(text);
    }
}