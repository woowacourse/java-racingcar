package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String SEPARATOR = ",";
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String carsName) {
        validateSeparator(carsName);
        String[] names = carsName.split(SEPARATOR);

        List<Car> cars = Arrays.stream(names)
                .map(Car::from)
                .collect(Collectors.toList());

        return new Cars(cars);
    }


    private static void validateSeparator(final String carsName) {
        if (carsName.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException();
        }
    }

    public void go(NumberGenerator generator) {
        cars.forEach(car -> car.go(generator.generate()));
    }

    public List<Car> findWinner() {
        //TODO: 예외 고민해보기
        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
