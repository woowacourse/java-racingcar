package validation;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantsValidator extends Validator<List<Car>> {

    public static final ParticipantsValidator PARTICIPANTS_VALIDATOR = new ParticipantsValidator();

    private static final String DUPLICATE_CAR_NAME = "자동차 이름은 중복될 수 없습니다.";

    private ParticipantsValidator() {
    }

    @Override
    public void validate(List<Car> cars) {
        List<String> carNames = cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        validateDuplication(carNames);
    }

    private void validateDuplication(final List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throwError(DUPLICATE_CAR_NAME);
        }
    }
}
