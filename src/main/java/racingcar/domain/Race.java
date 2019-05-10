package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final MovementStrategy strategy = new RandomMovement();
    private final List<Car> cars = new ArrayList<>();
    private int cursor = 0;

    public Race(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
        Collections.unmodifiableCollection(cars);
    }

    public Race(List<Car> cars, boolean foobar) { //타입 겹침 회피용
        cars.forEach(car -> this.cars.add(car));
        Collections.unmodifiableCollection(cars);
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    /*
    자동차 대수를 주기로 순서대로 진행함
     */
    public Car startRound() {
        return cars.get(cursor = (cursor + 1) % cars.size()).move(strategy);
    }

    public List<Car> getWinners() {
        Collections.sort(cars);
        Car winner = cars.get(0);
        return cars.stream().filter(x -> x.isAtSamePositionWith(winner)).collect(Collectors.toList());
    }
}