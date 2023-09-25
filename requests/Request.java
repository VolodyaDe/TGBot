package requests;

public class Request
{
    private final long m_userId;
    private final String m_message;

    public Request(String text, long userId)
    {
        m_message = text;
        m_userId = userId;
    }

    public String getMessage()
    {
        return m_message;
    }

    public long getUserId()
    {
        return m_userId;
    }
}
