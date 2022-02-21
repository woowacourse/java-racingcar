package racingcar.model.car;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.message.ErrorMessages;
import racingcar.util.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplicatedName(carNames);
        cars = carNames.stream()
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

    public void moveAll(RandomNumberGenerator random) {
        for (Car car : cars) {
            car.goOrStop(random.generate());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        return new Winners(cars).getNames();
    }

    private void validateDuplicatedName(List<String> carNames) {
        long distinctSize = carNames.stream()
                .distinct().count();
        if (distinctSize != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME);
        }
    }
}
