package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    
    public static int splitAndSum(String input) {
        if (input == null) {
            return 0;
        }
        
        Matcher m = Pattern.compile("//(.)\n(.*)")
                           .matcher(input);
        
        String regex = ",|:";
        
        if (m.find()) {
            String customDelimiter = m.group(1);
            input = m.group(2);
            regex = customDelimiter + "|" + regex;
        }
    
        String[] tokens = input.split(regex);
    
        int result = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                return 0;
            }

            result += new ZeroAndPositiveNumber(token).getValue();
        }
        
        return result;
    }
}
