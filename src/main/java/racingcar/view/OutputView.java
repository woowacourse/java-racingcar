package racingcar.view;

public class OutputView {
    private static final String WINNER_NAME_SEPARATOR = ",";

    public static void println(final String msg) {
        System.out.println(msg);
    }

    public static void printResult(final String result) {
        println(result);
        printLineBreak();
    }

    public static void printWinner(final String[] winnerNames) {
        String winningMsg = String.join(WINNER_NAME_SEPARATOR, winnerNames) + "가 최종 우승했습니다.";
        println(winningMsg);
    }

    private static void printLineBreak() {
        System.out.println();
    }
}
