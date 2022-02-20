package racingcar.view;

import java.util.Scanner;
import racingcar.utils.validator.RoundNumberValidator;

public class RoundInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static Integer getRound() {
        String roundNumberString = userRoundInput();
        try {
            return toIntWithValidate(roundNumberString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRound();
        }
    }

    private static Integer toIntWithValidate(String roundNumberString) {
        RoundNumberValidator.validate(roundNumberString);
        return Integer.valueOf(roundNumberString);
    }

    private static String userRoundInput() {
        System.out.println(ROUND_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
