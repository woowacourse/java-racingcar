package calculator;

public class StringCalculator {

    public static int splitAndSum(String targetString) {
        if (targetString == null || targetString.isBlank()){
            return 0;
        }

        int sum = 0;
        String[] splitResult = targetString.split("[,:]");
        for (String s : splitResult) {
            sum += toInt(s);
        }
        return sum;
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }
}
