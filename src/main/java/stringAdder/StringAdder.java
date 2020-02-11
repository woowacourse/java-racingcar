package stringAdder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    public static int add(String value) {
        String[] values = value.split(",|:");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[1]);
        return first + second;
    }
}