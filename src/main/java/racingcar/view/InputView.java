package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String inputCarNames() {
        printCarNameInputMessage();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }
}
