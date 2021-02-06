package racingcar.view;

import racingcar.model.Cars;

import java.util.Scanner;

public class InputView {

    private static Cars makeCars(String[] carNames) {
        return new Cars(carNames);
    }

    public static Cars getCars(Scanner scanner) {
        OutputView.printCarNameReadMessage();
        String userInput = scanner.nextLine();
        try {
            String[] carNames = userInput.split(",");
            return makeCars(carNames);
        } catch (Exception e) {
            return getCars(scanner);
        }
    }

    public static int getAttemptNumber(Scanner scanner) {
        OutputView.printAttemptNumberReadMessage();
        String userInput = scanner.nextLine();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            return getAttemptNumber(scanner);
        }
    }

}
