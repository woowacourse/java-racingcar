package stringAdder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    public static int add(String value) {
        int result = 0;

        if(value == null || value.isEmpty()){
            return 0;
        }
        String[] values = value.split(",|:");

        for(String number : values){
            result += Integer.parseInt(number);
        }
        return result;
    }
}