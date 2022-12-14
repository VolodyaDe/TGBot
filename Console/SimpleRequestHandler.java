public class SimpleRequestHandler implements RequestHandler
{
    @Override
    public Response handle(Request request)
    {
        return new Response(request.getMessage());
    }
}
