public class Main {
    public static void main(String[] args) {
        start();
    }

    public static int start() {
        Calculator calculator = new Calculator();

        try {
            return calculator.calculate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
            return start();
        }
    }
}
