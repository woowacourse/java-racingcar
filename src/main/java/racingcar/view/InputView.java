package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_DELIMITER = ",";

    private final InputViewValidator inputViewValidator = new InputViewValidator();

    public String[] readCarNames() {
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        inputViewValidator.validateCarNames(carNames);
        String[] splitCarNames = getSplitCarNames(carNames);
        inputViewValidator.validateSplitCarNames(splitCarNames);

        return splitCarNames;
    }

    private String[] getSplitCarNames(String carNames) {
        return carNames.split(CAR_NAMES_DELIMITER, -1);
    }

    public int readTryNum() {
        Scanner scanner = new Scanner(System.in);
        String tryNum = scanner.nextLine();
        inputViewValidator.validateTryNum(tryNum);
        return Integer.parseInt(tryNum);
    }
}
