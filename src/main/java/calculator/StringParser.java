package calculator;

import java.util.Scanner;

public class StringParser {
    String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    String[] split(String s) {
        return s.split(" ");
    }
}