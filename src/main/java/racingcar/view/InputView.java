package racingcar.view;

import java.util.Scanner;

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

        return input.nextLine().split(CAR_NAMES_SPLIT_REGEX);
    }

    private void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public String inputTryCount() {
        printTryCountInputMessage();

        return input.nextLine();
    }

    private void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }
}
