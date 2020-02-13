package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_NAMES_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_ROUND_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {}

    public static String inputNames() {
        System.out.println(INPUT_NAMES_GUIDE_MESSAGE);
        return SCANNER.nextLine();
    }

    public static int inputRound() {
        System.out.println(INPUT_ROUND_GUIDE_MESSAGE);
        return SCANNER.nextInt();
    }
}
