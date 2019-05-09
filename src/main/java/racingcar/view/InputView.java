package racingcar.view;

import racingcar.constant.Messages;
import racingcar.constant.Utils;

public class InputView {
    public static String inputCarList() {
        System.out.println(Messages.INPUT_CAR_LIST);
        try {
            return Utils.SCANNER.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarList();
        }
    }

    public static int inputTryCount() {
        System.out.println(Messages.INPUT_TRY_COUNT);
        try {
            return Utils.SCANNER.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputTryCount();
        }
    }
}