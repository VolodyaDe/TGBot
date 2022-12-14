public class BotResponseReplier implements ResponseReplier
{
    @Override
    public String reply(Response response)
    {
        return response.getMessage();
    }
}