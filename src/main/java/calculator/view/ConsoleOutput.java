package calculator.view;

public class ConsoleOutput {
    static final String SUMIS = "총합은 %d입니다.";

    public static void printSum(int sum) {
        System.out.println(String.format(SUMIS, sum));
    }
}
