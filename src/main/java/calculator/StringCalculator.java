package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    private static Delimiters delimiters = new Delimiters();

    public static int splitAndSum(String text) {
        if(isNull(text) || isEmpty(text)){
            return ZERO;
        }
        Matcher matchedPattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if(matchedPattern.find()){
            delimiters.addCustomDelimiters(matchedPattern.group(1));
            text = matchedPattern.group(2);
        }
        return splitAndSumByDelimiters(text);
    }

    private static boolean isNull(String text) {
        try{
            isEmpty(text);
        } catch (NullPointerException e){
            return true;
        }
        return false;
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static int splitAndSumByDelimiters(String text) {
        String[] numbers = text.split(delimiters.getDelimiters());
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int result = 0;
        for (String numberText : numbers){
            result += getValidatedNumber(numberText);
        }
        return result;
    }

    private static int getValidatedNumber(String numberText){
        try{
            return getPositiveNumber(Integer.parseInt(numberText));
        } catch(NumberFormatException e){
            throw new RuntimeException();
        }
    }

    private static int getPositiveNumber(int number) {
        if(number < 0){
            throw new RuntimeException();
        }
        return number;
    }
}
