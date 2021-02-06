package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return SCANNER.nextLine();
    }

    public static int getTryCounts() {
        System.out.println(INPUT_TRY_COUNTS_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
