package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_MENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)을 기준으로 구분)";
    private static final String INPUT_COUNT_MENT = "시도할 횟수는 몇회인가요?";
    private static Scanner SC = new Scanner(System.in);

    public static String getRacingCarInput() {
        System.out.println(INPUT_CAR_MENT);
        return SC.nextLine();
    }

    public static int getRacingCount() {
        System.out.println(INPUT_COUNT_MENT);
        return SC.nextInt();
    }

}
