package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.message.ErrorMessages;
import racingcar.util.RandomNumberGenerator;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] carNameArray = reduceBlank(carNames).split(DELIMITER);
        validateDuplicatedName(carNameArray);
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    public void moveAll(RandomNumberGenerator random) {
        for (Car car : cars) {
            car.goOrStop(random.generate());
        }
    }

    public List<CarStatus> getCarsStatus() {
        return cars.stream()
                .map(CarStatus::new)
                .collect(Collectors.toList());
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    private void validateDuplicatedName(String[] carNames) {
        long distinctSize = Arrays.stream(carNames)
                .distinct().count();
        if (distinctSize != carNames.length) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME);
        }
    }

    private String reduceBlank(String string) {
        return string.replaceAll(" ", "");
    }
}
