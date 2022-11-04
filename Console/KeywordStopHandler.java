package Console;

public class KeywordStopHandler implements StopHandler
{
    private final String stopWord;

    public KeywordStopHandler(String text)
    {
        stopWord = text;
    }

    public boolean needStop(Request request)
    {
        return stopWord.equals(request.message);
    }
}
