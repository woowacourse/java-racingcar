package racingcar.view;

public class ErrorView {

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }
}
