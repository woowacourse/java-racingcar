package racingcar.domain;

import racingcar.constant.ErrorConstant;
import racingcar.dto.CarStatus;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_CARS_COUNT = 2;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarsCount(cars.size());
        this.cars = cars;
    }

    private static void validateCarsCount(int size) {
        if (size < MINIMUM_CARS_COUNT) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "자동차 수는 2대 이상이어야 합니다.");
        }
    }

//    public List<CarStatus> moveCars(NumberGenerator numberGenerator) {
//        return cars.stream()
//                .map(car -> car.move(numberGenerator))
//                .collect(Collectors.toUnmodifiableList());
//    }
//
//    public List<CarStatus> getFinalPosition() {
//        return cars.stream()
//                .map(Car::getCarStatus)
//                .collect(Collectors.toUnmodifiableList());
//    }
//
//    public List<String> getWinnerCarsName() {
//        Car winner = getWinner();
//        return cars.stream()
//                .filter(car -> car.isSamePosition(winner))
//                .map(Car::getName)
//                .collect(Collectors.toUnmodifiableList());
//    }
//
//    private Car getWinner() {
//        return cars.stream()
//                .max(Car::compareTo)
//                .orElseThrow(() -> new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "비교할 자동차가 없습니다."));
//    }

}
