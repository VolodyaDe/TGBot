package Console;

import java.util.Scanner;

public class ConsoleRequestReader implements RequestReader
{
    public Request read()
    {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        return new Request(text);
    }
}