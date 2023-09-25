package requests;

public class Response
{
    private final long m_userId;
    private final String m_message;

    public Response(String text, long userId)
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
