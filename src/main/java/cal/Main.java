package cal;

public class Main {
    private static StrCalculator strCalculator  = new StrCalculator();
    public static void main(String[] args) {
        int result = inputStr();
        strCalculator.printResult(result);
    }

    public static int inputStr() {
        while (true){
            try {
                strCalculator.input();
//                return strCalculator.calculate();
                return strCalculator.calculateNoIfExpression();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
