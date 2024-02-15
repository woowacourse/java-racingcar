package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAMES_INPUT_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MSG = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public String readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MSG);
        return scanner.nextLine();
    }

    public String readTryCount() {
        System.out.println(TRY_COUNT_INPUT_MSG);
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
