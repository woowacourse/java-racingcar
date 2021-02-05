package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    
    private static final String DEFAULT_REGEX = ",|:";
    
    private static final String OR = "|";
    
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    
    private static final int NUMBERS_GROUP_INDEX = 2;
    
    private final String input;
    
    public Parser(String input) {
        this.input = input;
    }
    
    public String[] parse() {
        Matcher matcher = PATTERN.matcher(input);
        
        String numbersAndDelimiter = findNumbersAndDelimiter(matcher);
        String delimiter = findDelimiterRegex(matcher);
        
        return numbersAndDelimiter.split(delimiter);
    }
    
    private String findDelimiterRegex(Matcher matcher) {
        String regex = DEFAULT_REGEX;
        
        if (matcher.matches()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
            regex = customDelimiter + OR + DEFAULT_REGEX;
        }
        
        return regex;
    }
    
    private String findNumbersAndDelimiter(Matcher matcher) {
        if (matcher.matches()) {
            return matcher.group(NUMBERS_GROUP_INDEX);
        }
        
        return input;
    }
}
