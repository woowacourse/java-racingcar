package view;

public class InputView {

    private static final InputView INSTANCE = new InputView();

    private InputView() {}

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String[] readCarNames() {
        return new String[]{""};
    }

    private boolean isBlank(String inputValue) {
        return true;
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
