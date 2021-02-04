package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final int INIT_NUMBER = -1;

    private enum Delimiters{
        COMMA(","),
        COLON(":");

        private final String delimiter;

        private Delimiters(String delimiter) {
            this.delimiter = delimiter;
        }

        private static String getAllDelimiters(){
            List<String> delimiters = new ArrayList<String>();
            for(Delimiters delimiter : Delimiters.values()){
                delimiters.add(delimiter.delimiter);
            }
            return String.join("|\\", delimiters);
        }
    }

    public static int splitAndSum(String text) {
        int result = INIT_NUMBER;
        if(isNull(text)){
            result = ZERO;
            return result;
        }
        if(isEmpty(text)) {
            result = ZERO;
            return result;
        }
        if(isOnlyNumber(text)){
            result = Integer.parseInt(text);
            return result;
        }
        return splitByDelimiters(text);
    }

    private static boolean isNull(String text) {
        try{
            checkForNull(text);
        } catch (NullPointerException e){
            return true;
        }
        return false;
    }

    private static void checkForNull(String text) {
        text.isEmpty();
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isOnlyNumber(String text) {
        try{
            Integer.parseInt(text);
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    private static int splitByDelimiters(String text) {
        String[] numbers = text.split(Delimiters.getAllDelimiters());
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int result = 0;
        for (String number : numbers){
            result += Integer.parseInt(number);
        }
        return result;
    }
}
