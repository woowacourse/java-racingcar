package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    public static final int ZERO = 0;

    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public static String inputGameRound() {
        System.out.println("시도할 회수는 몇회인가요? (최대 10회)");
        return sc.nextLine();
    }
}
