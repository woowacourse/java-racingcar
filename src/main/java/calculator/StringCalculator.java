package calculator;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final int INIT_NUMBER = -1;
    private static final String DELIMITER = ",";
//    private static final String[] delimiters = {",", ":"};

//    public enum delimiters {
//        COMMA(","),
//        COLON(":");
//
//        private final String delimiter;
//        private delimiters(String delimiter) {
//            this.delimiter = delimiter;
//        }
//
//        public boolean isIncludeComma(String text){
//            if (text.contains(COMMA)){
//                return true;
//            }
//            return false;
//        }
//    }

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
        return splitByDelimiter(text, DELIMITER);
        //return result;
    }

    private static int splitByDelimiter(String text, String delimiter) {
        String[] numbers = text.split(delimiter);
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int result = 0;
        for (String number : numbers){
            result += Integer.parseInt(number);
        }
        return result;
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
}
