package service;

import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private final List<Car> carInformation = new ArrayList<>();

    public void saveCar(Car car) {
        carInformation.add(car);
    }

    public int findPositionByName(String name) {
        return carInformation.stream()
                .filter(car -> name.equals(car.getName()))
                .map(Car::getPosition)
                .findAny()
                .orElseThrow();
    }

    public List<String> findNameByPosition(int position) {
        return carInformation.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> positions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : carInformation) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public List<String> carNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : carInformation) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    public void poweInjectionByName(String carName, int power) {
        Car findedCar = carInformation.stream()
                .filter(car -> carName.equals(car.getName()))
                .findAny()
                .orElseThrow();

        findedCar.move(power);
    }

    public List<String> selectWinners() {
        return carInformation.stream()
                .filter(car -> Collections.max(positions()) == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

