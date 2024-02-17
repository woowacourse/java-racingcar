package racingcar.domain.car;

import racingcar.domain.generator.OilGenerator;
import racingcar.dto.CarPerformance;
import racingcar.dto.RoundResult;
import racingcar.exception.NoCarsToFindMaxDistanceException;

import java.util.Collections;
import java.util.List;

import static racingcar.constant.ExceptionMessage.DUPLICATED_CAR_NAME;

public class Cars {

    private final List<Car> cars;
    private final OilGenerator oilGenerator;

    public Cars(List<Car> cars, OilGenerator oilGenerator) {
        validateUniqueCarNames(cars);
        this.cars = Collections.unmodifiableList(cars);
        this.oilGenerator = oilGenerator;
    }

    public static Cars createCarsByName(List<String> carNames, OilGenerator oilGenerator) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(cars, oilGenerator);
    }

    public RoundResult moveCars() {
        List<CarPerformance> carPerformances = cars.stream()
                .map(this::moveCar)
                .toList();

        return new RoundResult(carPerformances);
    }

    public List<String> getWinnersName() {
        int maxDistance = findMaxDistance();

        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .map(Car::getName)
                .toList();
    }

    private void validateUniqueCarNames(List<Car> cars) {
        int uniqueCarNamesCount = (int)cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueCarNamesCount != cars.size()) {
            throw DUPLICATED_CAR_NAME.getException();
        }
    }

    private CarPerformance moveCar(Car car) {
        int oil = oilGenerator.generateValidOil();
        car.goIfOilEnough(oil);

        return car.getCurrentPerformance();
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElseThrow(NoCarsToFindMaxDistanceException::new);
    }
}
