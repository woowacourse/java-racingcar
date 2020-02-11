public class Calculator {

    public static int calculation(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public static String[] splitString(String s) {
        return s.split(",");
    }

    public static String[] spliStirngForColon(String s) {
        return s.split(":");
    }

    public static String addDelemeter(String s) {
        return s.substring(4,s.length());
    }
}
