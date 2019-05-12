package racingcargame.model;

import java.util.List;

class Round {
    static List<Car> round(List<Car> cars) {
        cars.forEach(car -> car.move(getRandomNo()));
        return cars;
    }

    private static int getRandomNo() {
        return (int) (Math.random() * 10);
    }
}
