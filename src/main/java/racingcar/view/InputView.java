package racingcar.view;

import racingcar.constant.MessageConstants;

import java.util.*;

import static racingcar.view.valid.InputValidException.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputName() {
        System.out.println(MessageConstants.INPUT_CARNAME);
        String[] inputName = scanner.nextLine().trim().split(",");

        if (overLengthName(inputName) || hasBlank(inputName) || hasNotAnotherPlayer(inputName)
                || overLapName(inputName) || hasMiddleBlank(inputName)) {
            return inputName();
        }

        return inputName;
    }

    public static int inputNumber() {
        System.out.println(MessageConstants.INPUT_ROUND);
        String inputNumber = scanner.nextLine();

        if (hasBlankNumber(inputNumber) || hasCharacter(inputNumber) || hasNegativeNumber(inputNumber)) {
            return inputNumber();
        }

        return Integer.parseInt(inputNumber);
    }

}
