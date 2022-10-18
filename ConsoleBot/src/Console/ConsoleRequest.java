package Console;

public class ConsoleRequest implements Request {
    private final String message;

    public ConsoleRequest(String text) {
        message = text;
    }

    public String getMsg() {
        return message;
    }
}