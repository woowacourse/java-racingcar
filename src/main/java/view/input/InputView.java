package view.input;

import java.util.Scanner;
import validation.ErrorMessages;
import validation.InputValidator;
import validation.ValidateResult;

public class InputView {

    private static String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String ENTER_COUNT = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    private String readLine() {
        return scanner.nextLine().strip();
    }

    public String getCarNames() {
        System.out.println(ENTER_CAR_NAMES);
        return getInput();
    }

    public String getCount() {
        System.out.println(ENTER_COUNT);
        return getInput();
    }

    private String getInput() {
        String input = readLine();
        validateEmpty(input);
        return input;
    }

    private void validateEmpty(String input) {
        ValidateResult validateResult = InputValidator.validate(input);
        if (validateResult == ValidateResult.FAIL_EMPTY) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.getMessage());
        }
    }
}
