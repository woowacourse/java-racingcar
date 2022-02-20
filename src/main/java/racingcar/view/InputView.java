package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String SEPARATOR = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String input = SCANNER.nextLine();
        String[] carNames = input.split(SEPARATOR);

        return carNames;
    }

    public static String getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        return SCANNER.nextLine();
    }
}
