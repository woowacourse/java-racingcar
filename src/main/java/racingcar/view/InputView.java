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
            return validatePositive(Integer.parseInt(userInput));
        } catch (Exception e) {
            OutputView.printErrorMessage("[Error] 횟수는 자연수여야 합니다.\n");
            return getUserTrialNumberInput(scanner);
        }
    }

    private static int validatePositive(int userInput) {
        if (userInput < 0) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }

}
