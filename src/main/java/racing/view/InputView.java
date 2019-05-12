package racing.view;

import racing.domain.RepeatNumber;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static String inputCarNames() {
        System.out.println(InputMessages.CAR_NAME.getMessage());
        scanner = new Scanner(System.in);
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
        System.out.println(InputMessages.REPEAT_NUMBER.getMessage());
        scanner = new Scanner(System.in);
        return getRepeatNumber(scanner.nextLine());
    }

    private static RepeatNumber getRepeatNumber(String repeatNumber) {
        try {
            return new RepeatNumber(repeatNumber);
        } catch (NumberFormatException e) {
            System.err.println(ErrorMessages.NOT_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return inputRepeatNumber();
    }

    protected static void checkIdentifier(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException(ErrorMessages.IDENTIFIER_NAME.getMessage());
        }
    }
}
