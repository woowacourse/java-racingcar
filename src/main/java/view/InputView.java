package view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final InputView INSTANCE = new InputView();

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CAR_NAMES_BLANK_ERROR = ERROR_PREFIX + "경주할 자동차 이름이 입력되지 않았습니다.";
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String CAR_NAMES_DUPLICATE_ERROR = ERROR_PREFIX + "경주할 자동차 이름이 중복되었습니다.";

    private final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String[] readCarNames() {
        String carNames = scanner.nextLine();
        validateCarNames(carNames);
        String[] splitCarNames = getSplitCarNames(carNames);
        validateSplitCarNames(splitCarNames);

        return new String[]{""};
    }

    private void validateCarNames(String carNames) {
        if (isBlank(carNames)) {
            throw new IllegalArgumentException(CAR_NAMES_BLANK_ERROR);
        }
    }

    private boolean isBlank(String inputValue) {
        return inputValue.equals("");
    }

    private String[] getSplitCarNames(String carNames) {
        return carNames.split(CAR_NAMES_DELIMITER);
    }

    private void validateSplitCarNames(String[] splitCarNames) {
        if (isDuplicated(splitCarNames)) {
            throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_ERROR);
        }
    }

    private void validateCarName(String carName) {

    }

    private boolean isDuplicated(String[] splitCarNames) {
        Set<String> removedDuplicatedSplitCarNames = Arrays.stream(splitCarNames)
                .collect(Collectors.toSet());
        return splitCarNames.length != removedDuplicatedSplitCarNames.size();
    }

    private boolean isCorrectCarNameLength(String carName) {
        return true;
    }

    public int readTryNum() {
        return 0;
    }

    private void validateTryNum(int tryNum) {

    }

    private boolean isInteger(int tryNum){
        return true;
    }

    private boolean isNotPositive(int tryNum) {
        return true;
    }





}
