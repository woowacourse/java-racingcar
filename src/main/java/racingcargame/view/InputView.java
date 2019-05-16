package racingcargame.view;

import java.util.*;

public class InputView {
    private static Scanner reader = new Scanner(System.in);

    public static String askCarNames() {
        System.out.println("자동차 이름을 입력해주세요! 자동차 이름은 쉼표로 구분합니다!");
        return reader.nextLine();
    }

    public static String askTotalTurns() {
        System.out.println("경기횟수를 입력해 주세요!");
        return reader.nextLine();
    }
}
