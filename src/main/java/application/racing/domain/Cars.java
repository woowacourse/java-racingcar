package application.racing.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final static String ERR_MESSAGE_FOR_DUPLICATE_NAME = "중복된 자동차 이름을 입력하였습니다.";

    List<Car> cars;

    public Cars(String name) {
        addCar(name);
        validateDuplicateCar();
    }

    private void addCar(String name) {
        String[] names = name.split(",");
        cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    private void validateDuplicateCar() {
        Set<Car> duplicateCar = new HashSet<>(cars);
        if (duplicateCar.size() != cars.size()) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_DUPLICATE_NAME);
        }
    }

    public void moveEachCar() {
        this.cars.stream()
                .forEach(car -> car.moveCar(new RandomNumber().getRandomNumber()));
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
