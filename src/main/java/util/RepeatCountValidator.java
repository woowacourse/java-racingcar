package util;

public class RepeatCountValidator implements Validator {

    private static final String NON_NUMBER_ERROR = "숫자만 입력 가능합니다.";
    private static final String NUMBER_OF_TIME_ERROR = "1 이상만 가능합니다.";

    private static final int NUMBER_OF_TIME_LOWER_BOUND = 0;
    private static final int NUMBER_OF_TIME_UPPER_BOUND = 101;

    @Override
    public void validate(Object target) {
        validateConvertInteger((String) target);
        validateRepeatCountRange((String) target);
    }

    private static void validateRepeatCountRange(String input) {
        int number = Integer.parseInt(input);

        if (number <= NUMBER_OF_TIME_LOWER_BOUND || NUMBER_OF_TIME_UPPER_BOUND <= number) {
            throw new IllegalArgumentException(NUMBER_OF_TIME_ERROR);
        }
    }

    private static void validateConvertInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_NUMBER_ERROR);
        }
    }
}
