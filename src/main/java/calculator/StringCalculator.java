package calculator;

public class StringCalculator {
    public static String[] splitString(String s) {
        String regExp = ",|:";
        if (isCustom(s)) {
            int idx = s.indexOf("\n");
            regExp = s.substring(2, idx);
            s = s.substring(idx + 1);
        }

        return s.split(regExp);
    }

    private static boolean isCustom(String s) {
        return s.startsWith("//") && s.contains("\n");
    }
}
