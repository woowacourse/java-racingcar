package stringAdder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    public static int add(String value) {
        if(value == null || value.isEmpty()){
            return 0;
        }
        String[] values = value.split(",|:");

        if(values.length == 1){
            return Integer.parseInt(values[0]);
        }
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[1]);
        return first + second;
    }
}