package racingcar.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public String EnterCarNames(){
        OutputView.askCarNames();
        return scanner.nextLine();
    }

    public static String[] splitName(String input) {
        String[] carNames = input.split(",");
        checkCarNames(carNames);
        return carNames;
    }

    private static void checkCarNames(String[] carNames) {
        for (String carName: carNames) {
            ValidateInput.isOverSixLetters(carName);
        }
    }
}
