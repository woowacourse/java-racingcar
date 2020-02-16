package application.racing.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final static String NAME_DELIMITER = ",";

    List<Car> cars;

    public Cars(String name) {
        initializeCar(name);
        validateDuplicateCar();
    }

    private void initializeCar(String name) {
        String[] names = name.split(NAME_DELIMITER);
        cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(new CarName(names[i])));
        }
    }

    private void validateDuplicateCar() {
        Set<Car> duplicateCar = new HashSet<>(cars);
        if (duplicateCar.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력하였습니다.");
        }
    }

    public void moveEachCar() {
        this.cars.stream()
                .forEach(car -> car.move(new RandomNumber().getRandomNumber()));
    }

    public List<String> findWinner() {
        int maxPosition = findMaxPosition();
        return this.cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return this.cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
