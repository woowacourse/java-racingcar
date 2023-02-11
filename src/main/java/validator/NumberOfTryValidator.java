package validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfTryValidator {
    private static final int MINIMUM_NUMBER_OF_TRY = 1;

    public static void validate(String numberOfTry) {
        validateNullAndEmpty(numberOfTry);
        validateNotNumeric(numberOfTry);
        validateTryNumberRange(Integer.parseInt(numberOfTry));
    }

    private static void validateNullAndEmpty(String numberOfTry) {
        if (Objects.isNull(numberOfTry) || numberOfTry.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }

    private static void validateNotNumeric(String numberOfTry) {
        Matcher matcher = Pattern.compile("[^0-9]").matcher(numberOfTry);
        if (matcher.find()) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    private static void validateTryNumberRange(int numberOfTry) {
        if (numberOfTry < MINIMUM_NUMBER_OF_TRY) {
            throw new IllegalArgumentException("1회 이상만 입력할 수 있습니다.");
        }
    }

}


