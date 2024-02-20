package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private static final String CAR_NAME_DELIMITER = ",";

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).");
        String carNames = scanner.nextLine();
        return carNames.split(CAR_NAME_DELIMITER);
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String tryCount = scanner.nextLine();
        return Integer.parseInt(tryCount);
    }
}
