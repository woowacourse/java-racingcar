package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.service.MoveOrStop;
import racingcar.utils.ExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int INITIAL_DISTANCE = 0;

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplication(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateDuplication(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_CAR_NAMES);
        }
    }

    public void move(MoveOrStop moveOrStop) {
        cars.forEach(car -> car.move(moveOrStop.determine()));
    }

    public List<CarDto> getCarInfos() {
        return cars.stream()
                .map(CarDto::toDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarDto> getFarthestCars() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(INITIAL_DISTANCE);

        List<CarDto> farthestCars = cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .map(CarDto::toDto)
                .collect(Collectors.toUnmodifiableList());

        return farthestCars;
    }

}
