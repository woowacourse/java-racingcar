package view;

import java.util.List;

public class OutputView {

    public static final String ERROR = "[ERROR]";

    public void printErrorMessage(String message) {
        System.out.println(ERROR + message);
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printMoveResult(List<String> moveResults) {
        moveResults.forEach(System.out::println);
        System.out.println();
    }
}
