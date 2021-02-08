package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String NOTICE_OF_INPUT_LAP = "시도할 회수는 몇회인가요?";
    private static final String NOTICE_OF_INPUT_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(NOTICE_OF_INPUT_NAMES);
        return scanner.nextLine();
    }

    public static String inputLap() {
        System.out.println(NOTICE_OF_INPUT_LAP);
        return scanner.nextLine();
    }
}
