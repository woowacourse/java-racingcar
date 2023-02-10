package validation;

import java.util.List;

public class ParticipantsValidator extends Validator<List<String>> {

    public static final ParticipantsValidator PARTICIPANTS_VALIDATOR = new ParticipantsValidator();

    private static final String DUPLICATE_CAR_NAME = "자동차 이름은 중복될 수 없습니다.";

    private ParticipantsValidator() {
    }

    @Override
    public void validate(List<String> carNames) {
        validateDuplication(carNames);
    }

    private void validateDuplication(final List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throwError(DUPLICATE_CAR_NAME);
        }
    }
}
