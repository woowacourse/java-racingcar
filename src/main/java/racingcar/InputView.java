package racingcar;

import java.util.Scanner;

public class InputView {
    public static final String REQUEST_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String getCarNames(Scanner scanner) {
        try {
            System.out.println(REQUEST_INPUT_NAMES);
            String inputValues = scanner.nextLine();
            NameValidator.validateNames(inputValues);
            return inputValues;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getCarNames(scanner);
        }
    }
}
