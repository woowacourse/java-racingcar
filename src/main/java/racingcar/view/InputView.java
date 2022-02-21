package racingcar.view;

import java.util.Scanner;
import racingcar.utils.GameMessage;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println(GameMessage.PRINT_CAR_CAR_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String getTryNo() {
        System.out.println(GameMessage.PRINT_GET_TRY_NO_MESSAGE);
        return scanner.nextLine();
    }

}
