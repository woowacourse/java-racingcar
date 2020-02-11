package study;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Scanner sc = new Scanner(System.in);

    public void run() {
        System.out.println("더하고 싶은 숫자를 입력해주세요! (기본 구분자는 ,와 : 입니다. 커스텀 구분자를 이용하시려면 //와 // 사이에 구분자를 넣어주세요.)");
        System.out.println("ex) 1,2,3 or //#//1#2#3");
        String input = null;
        while (true) {
            input = sc.next();
            try {
                System.out.println(calculate(input));
                break;
            } catch (RuntimeException e) {
                System.out.println("입력이 잘못됐습니다. 다시 입력해주세요");
            }
        }

    }

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

    private static boolean isNullOrEmtpy(String s) {
        return (s == null || s.isEmpty());
    }

    private static String[] getEquation(String s) {
        Matcher m = Pattern.compile("//(.)//(.*)").matcher(s);
        String[] tokens = null;
        if (m.find()) {
            String delimiter = m.group(1);
            tokens = m.group(2).split(delimiter);
        }
        return tokens;
    }

    private static int split(String[] strArr) {
        int result = 0;
        for (String str : strArr) {
            result += getAsNumber(str);
        }
        return result;
    }

    private static int getAsNumber(String s) {
        int result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 아니야");
        }
        return validate(result);
    }

    private static int validate(int number) {
        if (number < 0) {
            throw new RuntimeException("음수야");
        }
        return number;
    }

}
