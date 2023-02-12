package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private static final int ONLY_ONE_CAR = 1;
    private static final int BOUND = 10;
    private static final int DEFAULT_MAX = 0;

    private static final Random random = new Random();
    private static final String CAR_NAMES_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String names) {
        List<String> carNames = Arrays.asList(names.split(CAR_NAMES_DELIMITER));
        validateDuplicatedName(carNames);
        validateSoloPlay(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private static void validateSoloPlay(List<String> carNames) {
        if (carNames.size() == ONLY_ONE_CAR) {
            throw new IllegalArgumentException("[ERROR] 차를 둘 이상 입력하세요.");
        }
    }

    private static void validateDuplicatedName(List<String> carNames) {
        int carsSize = carNames.size();
        int duplicateRemovedCount =
                (int) carNames.stream()
                .distinct()
                .count();
        if (carsSize != duplicateRemovedCount) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름을 사용할 수 없습니다.");
        }
    }

    public void moveCarsRandomly() {

        cars.forEach(car -> car.move(random.nextInt(BOUND)));
    }

    public List<Winner> calculateWinners() {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_MAX);

        return cars.stream().filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .map(Winner::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
