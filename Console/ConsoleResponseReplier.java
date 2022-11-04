package Console;

public class ConsoleResponseReplier implements ResponseReplier
{
    public void reply(Response response)
    {
        System.out.println(response.message);
    }
}