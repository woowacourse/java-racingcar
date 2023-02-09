package view;

import java.util.Scanner;

public class InputView {

    private static final InputView INSTANCE = new InputView();

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CAR_NAMES_BLANK_ERROR = ERROR_PREFIX + "경주할 자동차 이름이 입력되지 않았습니다.";

    private final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String[] readCarNames() {
        String carNames = scanner.nextLine();

        validateCarNames(carNames);


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

    private String[] splitCarNames(String carNames) {
        return new String[]{""};
    }

    private void validateSplitCarNames(String[] splitCarNames) {

    }

    private void validateCarName(String carName) {

    }

    private boolean isDuplicated(String[] splitCarNames) {
        return true;
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
