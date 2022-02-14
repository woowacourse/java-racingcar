package racingcar.view;

import java.util.Scanner;

import racingcar.utils.validator.CarNamesValidator;
import racingcar.utils.validator.TryCountValidator;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAMES_SPLIT_REGEX = ",";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Scanner input;

    public InputView() {
        input = new Scanner(System.in);
    }

    public String[] inputCarNames() {
        printCarNameInputMessage();

        String[] carNames = input.nextLine().split(CAR_NAMES_SPLIT_REGEX);
        CarNamesValidator.validateCarNames(carNames);

        return carNames;
    }

    private void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public int inputTryCount() {
        printTryCountInputMessage();

        String tryCount = input.nextLine();
        TryCountValidator.validatePattern(tryCount);

        return Integer.parseInt(tryCount);
    }

    private void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }
}
