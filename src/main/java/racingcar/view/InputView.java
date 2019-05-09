package racingcar.view;

import racingcar.constant.Messages;
import racingcar.constant.Utils;

public class InputView {
    public String inputCarList() {
        System.out.println(Messages.INPUT_CAR_LIST);
        try {
            return Utils.SCANNER.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarList();
        }
    }
}