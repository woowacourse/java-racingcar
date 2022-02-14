package calculator;

import java.util.Scanner;

public class Main {

    private static final String CUSTOM_DELIMITER_ANNOUNCER_1 = "//";
    private static final String CUSTOM_DELIMITER_ANNOUNCER_2 = "\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.startsWith(CUSTOM_DELIMITER_ANNOUNCER_1)) {
            input += CUSTOM_DELIMITER_ANNOUNCER_2 + scanner.nextLine();
        }
        int result = Calculator.sum(input);
        System.out.println(result);
    }
}
