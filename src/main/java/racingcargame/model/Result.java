package racingcargame.model;

import racinginterface.ResultInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result implements ResultInterface {
    private List<Car> carList = new ArrayList<>();

    public Result(String[] names) {
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    @Override
    public List<Car> roundResult() {
        carList.forEach(Car::move);
        return carList;
    }

    @Override
    public List<String> gameResult() {
        int maxPosition = maxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
