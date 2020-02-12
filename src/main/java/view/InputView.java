package view;

import controller.ValidateInput;

import java.util.Scanner;

public class InputView {
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    public static final String ROUND_INPUT_MESSAGE = "시도할 횟수를 입력하세요";
    public static final String SPLIT_DELIMITER = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = scanner.next();
        return ValidateInput.validateName(nameSplit(input));
    }

    public static int inputRound() {
        System.out.println(ROUND_INPUT_MESSAGE);
        String input = scanner.next();
        return ValidateInput.ValidateCount(input);
    }

    public static String[] nameSplit(String input) {
        return input.split(SPLIT_DELIMITER);
    }
}
