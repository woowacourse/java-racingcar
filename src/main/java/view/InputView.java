package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).");
        String carNames = SCANNER.nextLine();
        return carNames.split(CAR_NAME_DELIMITER);
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String tryCount = SCANNER.nextLine();
        return Integer.parseInt(tryCount);
    }
}
