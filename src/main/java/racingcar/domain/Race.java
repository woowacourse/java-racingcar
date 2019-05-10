package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final MovementStrategy strategy = new RandomMovement();
    private final List<Car> cars = new ArrayList<>();
    private int cursor = -1;

    public Race(List<String> names) {
        names.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(name -> cars.add(new Car(name)));
        Collections.unmodifiableCollection(cars);
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    /*
    타입 겹침 회피용 인자 추가
     */
    public Race(List<Car> cars, boolean foobar) {
        cars.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(car -> this.cars.add(car));
        Collections.unmodifiableCollection(cars);
        if (this.cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
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
        Car oneOfTheWinners = Collections.max(cars);
        return cars.stream()
                .filter(x -> x.isAtSamePositionWith(oneOfTheWinners))
                .collect(Collectors.toList());
    }
}