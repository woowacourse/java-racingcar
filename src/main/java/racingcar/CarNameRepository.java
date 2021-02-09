package racingcar;

import java.util.*;

public class CarNameRepository {

    private static final int MINIMUM_CAR_AMOUNT = 2;
    private static final List<CarName> carNames = new ArrayList<>();

    private CarNameRepository() {
    }

    public static List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public static void addCarNames(List<String> carNamesInput) {
        validateNumberOfCar(carNamesInput);
        validateSameName(carNamesInput);
        carNamesInput.forEach(carName -> carNames.add(new CarName(carName)));
    }

    private static void validateNumberOfCar(List<String> carNamesInput) {
        if (carNamesInput.size() < MINIMUM_CAR_AMOUNT) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private static void validateSameName(List<String> carNamesInput) {
        Set<String> uniqueCarNames = new HashSet<>(carNamesInput);
        if (uniqueCarNames.size() != carNamesInput.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다.");
        }
    }
}
