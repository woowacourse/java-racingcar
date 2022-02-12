package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRIALS = "시도할 회수는 몇회인가요?";
    public static final String ERROR_MESSAGE_FOR_INVALID_TRIAL_INPUT = "올바른 숫자를 입력해주세요.";
    public static final int MINIMUM_TRIAL = 1;

    private final static Scanner SCANNER = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println(INPUT_CAR_NAMES);

        return SCANNER.nextLine();
    }

    public static int getTrial() {
        System.out.println(INPUT_TRIALS);
        final String trialInput = SCANNER.nextLine();

        validateTrialInput(trialInput);
        return stringToInt(trialInput);
    }

    private static void validateTrialInput(final String trialInput) {
        if (isNotValidTrialInput(trialInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_TRIAL_INPUT);
        }
    }

    private static boolean isNotValidTrialInput(final String numberInput) {
        return !isDigit(numberInput) || isSmallerThanOne(numberInput);
    }

    private static boolean isDigit(final String numberInput) {
        return numberInput.chars()
                        .allMatch(Character::isDigit);
    }

    private static boolean isSmallerThanOne(final String numberInput) {
        return stringToInt(numberInput) < MINIMUM_TRIAL;
    }

    private static int stringToInt(final String trialInput) {
        return Integer.parseInt(trialInput);
    }
}
