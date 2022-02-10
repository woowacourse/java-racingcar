package racingcar.view;

import racingcar.validator.MoveCountValidator;
import racingcar.validator.NameValidator;

import java.util.Scanner;

public class InputView {
    public static final String REQUEST_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_MOVE_COUNT = "시도할 회수는 몇회인가요?";

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

    public static String getMoveCount(Scanner scanner) {
        try {
            System.out.println(REQUEST_MOVE_COUNT);
            String inputValues = scanner.nextLine();
            MoveCountValidator.validateMoveCount(inputValues);
            return inputValues;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getMoveCount(scanner);
        }
    }
}
