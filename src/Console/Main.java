package Console;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String text = input.nextLine();
            if (text.equals("exit"))
                break;

            ConsoleRequest Set = new ConsoleRequest(text);
            String message = Set.getMessage();
            ConsoleReply Get = new ConsoleReply(message);
            Get.printMessage();
        }
    }
}
