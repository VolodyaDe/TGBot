package requests;

public class BotResponseReplier implements ResponseReplier
{
    @Override
    public String reply(Bucket request)
    {
        return request.getMessage();
    }
}
