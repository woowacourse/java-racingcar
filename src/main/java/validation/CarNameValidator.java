package validation;

import java.util.List;

public class CarNameValidator extends Validator<String> {

    public static final CarNameValidator CAR_NAME_VALIDATOR = new CarNameValidator();

    private static final String NOT_PROPER_CAR_NAME_LENGTH = "자동차 이름 길이는 %d자 이상, %d자 이하여야합니다.";
    private static final String DUPLICATE_CAR_NAME = "자동차 이름은 중복될 수 없습니다.";

    private CarNameValidator() {
    }

    @Override
    public void validate(final String carName) {
        validateLength(carName);
    }

    public void validate(final List<String> carNames) {
        validateDuplication(carNames);
    }

    private void validateDuplication(final List<String> carNames) {

        if (carNames.stream().distinct().count() != carNames.size()) {
            throwError(DUPLICATE_CAR_NAME);
        }
    }

    private void validateLength(final String carName) {
        final int MIN_CAR_NAME_LENGTH = 1;
        final int MAX_CAR_NAME_LENGTH = 5;

        if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
            throwError(String.format(NOT_PROPER_CAR_NAME_LENGTH, MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH));
        }
    }
}
