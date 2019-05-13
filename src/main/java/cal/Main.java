package cal;

public class Main {
    public static void main(String[] args) {
        StrCalculator strCalculator = new StrCalculator();
        String[] exp = strCalculator.input();
        int result = strCalculator.calculate(exp);
        strCalculator.printResult(exp,result);
    }
}
