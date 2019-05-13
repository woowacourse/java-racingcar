package racing.view;


import java.util.Scanner;

public class InputView {
    public static String inputCarNames() {
        System.out.println(ConsoleMessages.INPUT_CAR_NAME.getMessage());
        String carNames = new Scanner(System.in).nextLine();

        try {
            checkIdentifier(carNames);
            return carNames;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputCarNames();
        }
    }

    public static String inputRepeatNumber() {
        System.out.println(ConsoleMessages.INPUT_REPEAT_NUMBER.getMessage());
        return new Scanner(System.in).nextLine();
    }

    protected static void checkIdentifier(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_IDENTIFIER_NAME.getMessage());
        }
    }


}
