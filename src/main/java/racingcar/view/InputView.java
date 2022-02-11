package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCarNames() {
        printCarNameInputMessage();

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public String inputTryCount() {
        printTryCountInputMessage();

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }
}
