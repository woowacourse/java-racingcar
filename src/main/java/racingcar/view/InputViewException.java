package racingcar.view;

public class InputViewException {
    public static int askAndReceiveTotalTurns() {
        try {
            int userInput = InputView.askAndReceiveTurns();
            checkConditionsForTurns(userInput);
            return userInput;
        } catch (Exception e) {
            return askAndReceiveTotalTurns();
        }
    }

    public static void checkConditionsForTurns(int userInput) {
        if (userInput <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
