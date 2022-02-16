package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_SCAN_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_SCAN_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static String scanCarNames() {
        OutputView.printMessage(CAR_NAME_SCAN_MESSAGE);
        return scanner.nextLine().trim();
    }

    public static String scanTryCount() {
        OutputView.printMessage(TRY_COUNT_SCAN_MESSAGE);
        return scanner.nextLine().trim();
    }
}
