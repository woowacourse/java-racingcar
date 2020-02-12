package view;

import controller.ValidateInput;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String input = scanner.next();
        return ValidateInput.validateName(nameSplit(input));
    }

    public static int inputCount() {
        System.out.println("시도할 횟수를 입력하세요");
        String input = scanner.next();
        return ValidateInput.ValidateCount(input);
    }

    public static String[] nameSplit(String input) {
        return input.split(",");
    }
}
