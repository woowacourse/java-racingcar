package validation;

public class CarNameValidator extends Validator<String> {

    public static final CarNameValidator CAR_NAME_VALIDATOR = new CarNameValidator();

    private static final String NOT_PROPER_CAR_NAME_LENGTH = "자동차 이름 길이는 %d자 이상, %d자 이하여야합니다.";
    private static final String CONTAINS_DELIMITER = "자동차 이름은 '-'를 포함할 수 없습니다";

    private CarNameValidator() {
    }

    @Override
    public void validate(final String carName) {
        validateLength(carName);
        validateNotContainingDelimiter(carName);
    }

    private void validateLength(final String carName) {
        final int MIN_CAR_NAME_LENGTH = 1;
        final int MAX_CAR_NAME_LENGTH = 5;

        if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
            throwError(String.format(NOT_PROPER_CAR_NAME_LENGTH, MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH));
        }
    }

    private static void validateNotContainingDelimiter(final String carName) {
        if (carName.contains("-")) {
            throwError(CONTAINS_DELIMITER);
        }
    }
}
