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
        carNamesInput.stream().map(carName -> carNames.add(new CarName(carName)));
        validateNumberOfCar();
        validateSameName();
    }

    private static void validateNumberOfCar() {
        if (carNames.size() < MINIMUM_CAR_AMOUNT) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private static void validateSameName() {
        Set<CarName> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다.");
        }
    }
}
