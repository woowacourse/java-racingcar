package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final InputView INSTANCE = new InputView();

    private static final String CAR_NAMES_DELIMITER = ",";

    private InputViewValidator inputViewValidator = InputViewValidator.getInstance();

    private InputView() {}

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String[] readCarNames() {
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        inputViewValidator.validateCarNames(carNames);
        String[] splitCarNames = getSplitCarNames(carNames);
        for (String splitCarName : splitCarNames) {
            inputViewValidator.validateSplitCarName(splitCarName);
        }
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
