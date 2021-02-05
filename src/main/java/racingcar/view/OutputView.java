package racingcar.view;

public class OutputView {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Messages message) {
        System.out.println(message.getMessage());
    }
}
