package Console;

import java.util.Scanner;

public class ConsoleRequestReader implements RequestReader
{
    private final Scanner input = new Scanner(System.in);

    @Override
    public Request read()
    {
        String text = input.nextLine();
        return new Request(text);
    }
}