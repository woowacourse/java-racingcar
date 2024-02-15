package racingcar.view;

public class OutputView {
    private static final String NEWLINE = System.lineSeparator();
    private static final String RESULT_MESSAGE = NEWLINE + "실행 결과";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
