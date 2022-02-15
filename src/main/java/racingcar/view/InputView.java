package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_SPLIT_REGEX = ",";
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String[] inputCarNames() {
        printCarNameInputMessage();

        return trim(split(new Scanner(System.in).nextLine()));
    }

    private void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    private String[] split(final String carNames) {
        return carNames.split(CAR_NAMES_SPLIT_REGEX);
    }

    private String[] trim(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .toArray(String[]::new);
    }

    public String inputTryCount() {
        printTryCountInputMessage();

        return new Scanner(System.in).nextLine();
    }

    private void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }
}
