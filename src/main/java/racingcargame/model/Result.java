package racingcargame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private List<Car> carList = new ArrayList<>();

    public Result(String[] names) {
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public Result(List<Car> carList){
        this.carList = carList;
    }

    public List<Car> roundResult() {
        carList.forEach(car -> car.move(getRandomNo()));
        return carList;
    }

    private int getRandomNo() {
        return (int) (Math.random() * 10);
    }

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
