package racingcar.view;

import java.util.Scanner;

import static racingcar.message.NotificationMessage.INPUT_CAR_NAMES;
import static racingcar.message.NotificationMessage.INPUT_TOTAL_LAP;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return sc.nextLine();
    }

    public static int inputTotalLap() {
        System.out.println(INPUT_TOTAL_LAP);
        String input = sc.nextLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("전체 바퀴 수는 숫자만 입력 가능합니다.");
        }
    }
}
