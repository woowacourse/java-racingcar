package racingcargame.view.intput;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String askCarNames() {
        System.out.println("자동차 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String askRound() {
        System.out.println("시도 횟수를 입력하세요.");
        return scanner.nextLine();
    }

}
