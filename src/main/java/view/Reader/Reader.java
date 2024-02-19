package view.Reader;

import java.util.Scanner;

public class Reader {
    Scanner scanner = new Scanner(System.in);

    public String readLineWithTrim() {
        return scanner.nextLine().trim();
    }
}
