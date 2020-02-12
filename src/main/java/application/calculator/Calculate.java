package application.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final String BASIC_DELIMITER = ",|:";
    public static final int DELIMITER_INDEX = 1;
    public static final int TOKENS_INDEX = 2;
    public static final int ZERO = 0;
    public static final String EMPTY = "";

    public int calculateStringEquation(String stringEquation) {
        Matcher customEquation = Pattern.compile(CUSTOM_DELIMITER).matcher(stringEquation);
        int result;
        if(customEquation.find()) {
            String customDelimiter = customEquation.group(DELIMITER_INDEX);
            String[] tokens = customEquation.group(TOKENS_INDEX).split(customDelimiter);
            return sumTokens(tokens);
        }
        result = calculateBasicEquation(stringEquation);
        return result;
    }

    private int calculateBasicEquation(String stringEquation) {
        String[] tokens = stringEquation.split(BASIC_DELIMITER);
        return sumTokens(tokens);
    }

    public int sumTokens(String[] tokens){
        int result = 0;
        for(String token : tokens) {
            result = calculateResult(result, token);
        }
        return result;
    }

    private int calculateResult(int result, String token) {
        int tokenNumber;
        tokenNumber = checkNullOrEmptyOrInteger(token);
        checkNegativeNumber(tokenNumber);
        result += Integer.parseInt(token);
        return result;
    }

    public int checkNullOrEmptyOrInteger(String input) {
        if(isNullOrEmptyEquation(input)) {
            return ZERO;
        }
        return checkIntegerNumber(input);
    }

    public void checkNegativeNumber(int tokenNumber) {
        if(isNegativeNumber(tokenNumber)) {
            throw new RuntimeException();
        }
    }

    private boolean isNegativeNumber(int tokenNumber) {
        return tokenNumber < ZERO;
    }

    private int checkIntegerNumber(String token) {
        return Integer.parseInt(token);
    }

    private boolean isNullOrEmptyEquation(String input) {
        return input == null || EMPTY.equals(input);
    }
}