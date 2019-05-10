package racingcargame.model;

import java.util.List;

class Round {

    List<Car> round(List<Car> cars) {
        cars.forEach(car -> car.move(getRandomNo()));
        return cars;
    }

    private int getRandomNo() {
        return (int) (Math.random() * 10);
    }
}
