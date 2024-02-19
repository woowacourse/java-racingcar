package racing.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racing.util.RandomGenerator;

public class Cars {
    private List<Car> cars;

    public Cars(String rawNames) {
        List<String> carNames = parseNames(rawNames);
        validateDuplicateName(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private static void validateDuplicateName(List<String> carNames) {
        int count = (int) carNames.stream().distinct().count();
        if (count != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> parseNames(String names) {
        return Arrays.stream(names.split(",")).map(String::trim).toList();
    }

    public void proceedRound() {
        cars.forEach(car -> car.moveByNumber(RandomGenerator.generate()));
    }


    public List<Car> findWinners() {
        Collections.sort(cars);
        return cars.stream().filter((car) -> car.isSamePosition(cars.get(0))).toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
