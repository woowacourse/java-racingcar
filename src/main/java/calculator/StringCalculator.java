package calculator;

public class StringCalculator {
    private static final int ZERO = 0;
    public static final int INIT_NUMBER = -1;

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
        return result;
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static void checkForNull(String text) {
        text.isEmpty();
    }

    private static boolean isNull(String text) {
        try{
            checkForNull(text);
        } catch (NullPointerException e){
            return true;
        }
        return false;
    }
}
