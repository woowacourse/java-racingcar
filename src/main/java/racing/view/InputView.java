package racing.view;

import racing.domain.RepeatNumber;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(ConsoleMessages.INPUT_CAR_NAME.getMessage());
        String carNames = scanner.nextLine();

        try {
            checkIdentifier(carNames);
            return carNames;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputCarNames();
        }
    }

    public static RepeatNumber inputRepeatNumber() {
        System.out.println(ConsoleMessages.INPUT_REPEAT_NUMBER.getMessage());
        return getRepeatNumber(scanner.nextLine());
    }

    private static RepeatNumber getRepeatNumber(String repeatNumber) {
        try {
            return new RepeatNumber(repeatNumber);
        } catch (NumberFormatException e) {
            System.err.println(ConsoleMessages.ERR_REPEAT_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return inputRepeatNumber();
    }

    protected static void checkIdentifier(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_IDENTIFIER_NAME.getMessage());
        }
    }


}
