package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇회인가요?";

    private static final Scanner sc = new Scanner(System.in);

    public static String askCarName() {
        System.out.println(QUESTION_CAR_NAME);
        return sc.nextLine();
    }


    public static String askTryCount() {
        System.out.println(QUESTION_TRY_COUNT);
        return sc.nextLine();
    }

}
