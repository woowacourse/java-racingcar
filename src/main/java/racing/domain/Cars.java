package racing.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.util.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(String rawNames) {
        List<String> carNames = parseNames(rawNames);
        validate(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    Cars(List<String> carNames, List<Integer> positions) {
        validate(carNames);
        this.cars = IntStream.range(0, carNames.size())
                .mapToObj(i -> new Car(carNames.get(i), positions.get(i)))
                .collect(Collectors.toList());
    }

    private List<String> parseNames(String names) {
        return Arrays.stream(names.split(",")).map(String::trim).toList();
    }

    private void validate(List<String> cars) {
        validateDuplicateName(cars);
    }

    private void validateDuplicateName(List<String> cars) {
        int count = (int) cars.stream().distinct().count();
        if (count != cars.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    public void moveAll(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.moveByNumber(numberGenerator.generate()));
    }

    public List<Car> findFurthestCars() {
        Collections.sort(cars);
        return cars.stream().filter((car) -> car.isSame(cars.get(0))).toList();
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n", "", "\n"));
    }
}
