package racingcar.domain;

import racingcar.domain.data.Car;
import racingcar.utils.exception.DuplicateNameException;
import racingcar.utils.exception.NotEnoughCarException;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static int CAR_MIN_NUMBER = 2;
    private static List<Car> cars;
    private int maxPosition = 0;

    public Cars(String[] names) {
        cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name, new RandomNumberRule());
            isDuplicate(car);
            cars.add(car);
        }
        notEnoughCar(cars);
    }

    private void notEnoughCar(List<Car> cars) {
        if (cars.size() < CAR_MIN_NUMBER) {
            throw new NotEnoughCarException(CAR_MIN_NUMBER);
        }
    }

    private void isDuplicate(Car car) {
        if (cars.contains(car)) {
            throw new DuplicateNameException();
        }
    }

    public void startRace() {
        for (Car car : cars) {
            car.move();
            maxPosition = car.aboveMaxPosition(maxPosition);
        }
    }

    public Map<String, Integer> getStates() {
        Map<String, Integer> states = new HashMap<>();
        for (Car car : cars) {
            states.put(car.getName(), car.getPosition());
        }
        return states;
    }

    public List<String> showWinners() {
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}