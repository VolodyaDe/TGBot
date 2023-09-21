package requests;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface RequestReader
{
    Bucket read(Update update);
}
