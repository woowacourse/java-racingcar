package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_REQUEST_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public static String getCarNameInput() {
        OutputView.printMessage(INPUT_REQUEST_RACING_CAR_NAME);
        return scanner.nextLine();
    }

    public static String getTryCountInput() {
        OutputView.printMessage(INPUT_REQUEST_TRY_COUNT);
        return scanner.nextLine();
    }
}
