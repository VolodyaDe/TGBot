package requests;

public class Bucket
{
    private final String m_message;

    public Bucket(String text)
    {
        m_message = text;
    }

    public String getMessage()
    {
        return m_message;
    }
}
