package Console;

public class SimpleRequestHandler implements RequestHandler
{
    public Response handle(Request request)
    {
        return new Response(request.message);
    }
}
