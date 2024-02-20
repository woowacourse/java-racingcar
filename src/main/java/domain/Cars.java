package domain;

import dto.CarStatus;
import dto.CarsStatus;
import dto.Winners;
import exception.ErrorMessage;
import exception.RacingCarGameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        validateUniqueName(carNames);
        List<Car> cars = convertToCarList(carNames);
        return new Cars(cars);
    }

    private static void validateUniqueName(List<String> names) {
        if(isDuplicatedName(names)) {
            throw RacingCarGameException.from(ErrorMessage.DUPLICATED_NAME_ERROR);
        }
    }

    private static boolean isDuplicatedName(List<String> names) {
        return getDistinctCount(names) != names.size();
    }

    private static int getDistinctCount(List<String> names) {
        return (int) names.stream()
                .distinct()
                .count();
    }

    private static List<Car> convertToCarList(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(new CarName(name)))
                .toList();
    }

    public CarsStatus move(NumberGenerator generator) {
        List<CarStatus> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            int number = generator.generate();
            carStatuses.add(car.move(number));
        }
        return new CarsStatus(carStatuses);
    }

    public Winners judge() {
        int max = findMaxPosition();
        List<String> winnerNames = cars.stream()
                .filter(car -> car.isWinner(max))
                .map(Car::getName)
                .toList();
        return new Winners(winnerNames);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElseThrow(() -> new IllegalStateException());
    }
}
