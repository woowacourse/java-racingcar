package racingcargame.view.intput;

import java.util.Scanner;

public class InputView {

    public static final String INPUT_CAR_NAME_STATEMENT = "자동차 이름을 입력하세요.";
    public static final String INPUT_TRIALTIMES_STATEMENT = "시도 횟수를 입력하세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static String askCarNames() {
        System.out.println(INPUT_CAR_NAME_STATEMENT);
        return scanner.nextLine();
    }

    public static String askRound() {
        System.out.println(INPUT_TRIALTIMES_STATEMENT);
        return scanner.nextLine();
    }

}
