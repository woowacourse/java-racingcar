package racingcar.view;

import java.util.Scanner;
import racingcar.utils.Constant;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println(Constant.PRINT_CAR_CAR_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String getTryNo() {
        System.out.println(Constant.PRINT_GET_TRY_NO_MESSAGE);
        return scanner.nextLine();
    }

}
