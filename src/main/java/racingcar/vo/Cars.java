package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.numbergenerator.NumberGenerator;
import racingcar.util.CarMakerUtil;
import racingcar.view.ErrorMessage;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        cars = CarMakerUtil.createCarsWith(names);
    }

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars raceAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
        return new Cars(cars);
    }

    public Winners judgeWinners() {
        Car maxPositionCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchElementException(ErrorMessage.CAR_NOT_FOUND.getMessage()));
        return new Winners(cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList()));
    }

    public boolean isSameSize(int size) {
        return cars.size() == size;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
