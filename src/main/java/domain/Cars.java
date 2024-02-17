package domain;

import java.util.List;

public class Cars {

    private final List<Car> carList;
    private final MoveStrategy moveStrategy;

    public Cars(List<Car> carList, MoveStrategy moveStrategy) {
        this.carList = carList;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        carList.forEach(car -> car.move(moveStrategy.isMove()));
    }

    public List<Car> findWinner() {
        int maxPosition = carList.stream().mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
