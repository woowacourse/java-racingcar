package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import racingcar.util.CarUtil;

public class Cars implements Iterable<Car> {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException();
        }
        this.cars = cars;
    }

    public int maxPosition() {
        Collections.sort(cars);
        return cars.get(0).getPosition();
    }

    public void move() {
        for (Car car : cars) {
            car.move(CarUtil.random());
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = maxPosition();
        for (Car car : cars) {
            winners.add(car.nameIfOn(maxPosition));
        }
        return winners;
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
