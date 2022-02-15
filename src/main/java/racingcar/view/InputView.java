package racingcar.view;

import java.util.Scanner;
import racingcar.message.NoticeMessages;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(NoticeMessages.INPUT_CAR_NAMES);
        return scanner.nextLine();
    }

    public static String inputTryCount() {
        System.out.println(NoticeMessages.INPUT_TRY_CNT);
        return scanner.nextLine();
    }
}
