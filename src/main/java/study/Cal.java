package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cal {
    public static int calculate(String s) {
        if (isNullOrEmtpy(s)) {
            return 0;
        }
        String[] strArr = getEquation(s);
        if (strArr == null) {
            strArr = s.split(",|:");
        }
        return split(strArr);
    }

    private static boolean isNullOrEmtpy(String s){
        return (s == null || s.isEmpty());
    }

    private static String[] getEquation(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        String[] tokens = null;
        if (m.find()) {
            String delimeter = m.group(1);
            tokens = m.group(2).split(delimeter);
        }
        return tokens;
    }

    private static int split(String[] strArr){
        int result = 0;
        for (String str : strArr){
            result += getAsNumber(str);
        }
        return result;
    }

    private static int getAsNumber(String s) {
        int result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        return validate(result);
    }

    private static int validate(int number){
        if (number < 0) {
            throw new RuntimeException();
        }
        return  number;
    }

}
