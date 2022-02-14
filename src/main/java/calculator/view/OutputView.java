package calculator.view;

public class OutputView {
    private static final String SUM_OF_NUMBER = "숫자의 합: ";

    private OutputView() {
    }

    public static void showSum(int number) {
        System.out.println(SUM_OF_NUMBER + number);
    }
}
