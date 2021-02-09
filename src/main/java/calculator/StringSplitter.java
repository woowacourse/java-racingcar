package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_REGEX = ",|:";
    private static final String OR = "|";
    
    private String input;
    
    public StringSplitter(String input) {
        this.input = input;
    }
    
    public String[] getStringSplitter() {
        final String delimiter = getDelimiter();
        
        return input.split(delimiter);
    }
    
    public String getDelimiter() {
        Matcher matcher = PATTERN.matcher(input);
        
        String regex = DEFAULT_REGEX;
        
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            input = matcher.group(2);
            regex = customDelimiter + OR + DEFAULT_REGEX;
        }
        
        return regex;
    }
}
