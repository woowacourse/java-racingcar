package racing.view;

import java.util.Scanner;

public class InputView {
    static final Scanner SCANNER = new Scanner(System.in);
    static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.이름은 쉼표(,)를 기준으로 구분).";
    static final String ASK_ROUND_NUMBERS = "시도할 횟수는 몇회인가요?";

    public static String getCarNames() {
        System.out.println(ASK_CAR_NAMES);

        return SCANNER.nextLine();
    }

    public static int getRoundNumber() {
        System.out.println(ASK_ROUND_NUMBERS);

        return Integer.parseInt(SCANNER.nextLine());
    }
}
