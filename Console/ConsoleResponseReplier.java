package Console;

public class ConsoleResponseReplier implements ResponseReplier
{
    @Override
    public void reply(Response response)
    {
        System.out.println(response.getMessage());
    }
}