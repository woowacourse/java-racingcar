package view;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String readLineWithTrim() {
        return scanner.nextLine().trim();
    }
}
