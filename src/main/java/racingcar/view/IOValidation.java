package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.InputMismatchException;

public class IOValidation {
    public static List<String> filterTypos(String arg) {
        return new ArrayList<>(
                Arrays.stream(arg.split(","))
                .filter(x -> (!x.equals("")) && (!x.equals(" ")) && (!x.equals(",")))
                .map(x -> x.trim())
                .collect(Collectors.toList())
        );
    }

    public static boolean areValidNames(List<String> names) {
        return names.size() > 1
                && names.size() == new HashSet<>(names).size()
                && names.stream().map(x -> x.length() <= 5).reduce(true, (x, y) -> x && y);
    }

    public static boolean isValidNumber(String line) {
        try {
            return Integer.parseInt(line) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static String differentiateIGa(final char letter) {
        final char[] CONVERSION_TABLE = ("영일이삼사오육칠팔구:;<=>?@"
                + "이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
                + "[원]^_`이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
        ).toCharArray();
        if (48 <= letter && letter <= 122) {
            return ((CONVERSION_TABLE[letter - 48] - 0xAC00) % 28 == 0) ? "가" : "이";
        }

        return ((letter - 0xAC00) % 28 == 0) ? "가" : "이";
    }
}