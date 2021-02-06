package racingcar.view;

import racingcar.model.Cars;

import java.util.Scanner;

public class InputView {
    public static Cars getUserCarInput(Scanner scanner) {
        OutputView.readCarName();
        String userInput = scanner.nextLine();
        try {
            String[] carNames = userInput.split(",");
            return makeCars(carNames);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserCarInput(scanner);
        }
    }

    private static Cars makeCars(String[] carNames) {
        return new Cars(carNames);
    }

    public static int getUserTrialNumberInput(Scanner scanner) {
        OutputView.readTrialNumber();
        String userInput = scanner.nextLine();
        try {
            return Integer.parseInt(userInput); //정규식도입? 예외처리?
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserTrialNumberInput(scanner);
        }
    }
}
