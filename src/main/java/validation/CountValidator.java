package validation;

public class CountValidator extends Validator<Integer> {

    public static final CountValidator COUNT_VALIDATOR = new CountValidator();

    private static final String NOT_PROPER_COUNT = "올바르지 않은 시도횟수입니다.(1 ~ 999,999,999)";

    private CountValidator() {
    }

    @Override
    public void validate(final Integer count) {
        validateRange(count);
    }

    public void validate(final String count) {
        validatePositiveNumber(count);
        validate(Integer.parseInt(count));
    }

    private void validatePositiveNumber(final String count) {
        final String POSITIVE_NUMBER_REGEX = "^[1-9]\\d{0,8}$";
        if (!count.matches(POSITIVE_NUMBER_REGEX)) {
            throwError(NOT_PROPER_COUNT);
        }
    }

    private void validateRange(final int count) {
        final int MIN_COUNT = 1;
        final int MAX_COUNT = 999_999_999;

        if (count < MIN_COUNT || count > MAX_COUNT) {
            throwError(NOT_PROPER_COUNT);
        }
    }
}
