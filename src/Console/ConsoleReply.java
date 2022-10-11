package Console;

public class ConsoleReply implements Reply {
    private final String message;

    public ConsoleReply(String text) {
        message = text;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
