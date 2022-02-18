package racingcar.view;

import racingcar.util.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String getInput() {
        return scanner.nextLine();
    }
    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String input = getInput();
        InputValidator.validateBlank(input);
        return input;
    }

    public static String inputTrialNum() {
        System.out.println("시도할 회수는 몇회인가요?");

        String input = getInput();
        InputValidator.validateBlank(input);
        return input;
    }
}
