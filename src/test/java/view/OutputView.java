package view;

public class OutputView {

    public static final String ERROR = "[ERROR]";

    public void printErrorMessage(String message) {
        System.out.println(ERROR + message);
    }
}
