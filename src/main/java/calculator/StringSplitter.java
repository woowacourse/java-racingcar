package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static StringSplitter stringSplitter = new StringSplitter();

    private StringSplitter(){}

    public static StringSplitter getInstance() {
        return stringSplitter;
    }

    public String[] parseString(String str){
        if(str.contains(",|:")){
            return defaultSplit(str);
        }

        return customSplit(str);
    }

    private String[] defaultSplit(String str) {
        return str.split(",|:");
    }

    private String[] customSplit(String str) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);

        return tokens;
    }

}
