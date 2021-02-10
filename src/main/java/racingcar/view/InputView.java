package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분";
    private static final String INPUT_ROUND = "시도할 횟수는 몇 회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("InputView can't be initialized because it is a view");
    }

    public static String inputNames() {
        return userStringInput(INPUT_CAR_NAMES);
    }

    public static String inputRound() {
        return userStringInput(INPUT_ROUND);
    }

    private static String userStringInput(final String instruction) {
        System.out.println(System.lineSeparator() + instruction);
        return scanner.nextLine().trim();
    }
}
