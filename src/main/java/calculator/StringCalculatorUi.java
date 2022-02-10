package calculator;

import java.util.Scanner;

public class StringCalculatorUi {

    private static final String INPUT_MESSAGE = "더할 값을 입력하세요:";
    private static final String OUTPUT_MESSAGE = "결과 값은 %d 입니다.\n";
    private static final String CUSTOM_SEPARATOR_FIRST_CONDITION = "//";
    private static final String CUSTOM_SEPARATOR_SECOND_CONDITION = "\n";

    public static void printOutput(int output) {
        System.out.printf(OUTPUT_MESSAGE, output);
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_MESSAGE);
        String input = scanner.nextLine();
        if (input.contains(CUSTOM_SEPARATOR_FIRST_CONDITION)) {
            String additionalInput = scanner.nextLine();
            return input + CUSTOM_SEPARATOR_SECOND_CONDITION + additionalInput;
        }
        return input;
    }
}
