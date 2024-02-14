package racing.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Racing {
    private final List<Car> cars;
    private final int maxTurn;
    private int turn;

    public Racing(List<Car> cars, int maxTurn) {
        this.cars = Collections.unmodifiableList(cars);
        this.maxTurn = maxTurn;
    }

    void doRace(List<Integer> numbers) {
        if (turn == maxTurn) {
            return;
        }
        for (int index = 0; index < cars.size(); index++) {
            Car car = cars.get(index);
            Integer raceCondition = numbers.get(index);
            doRace(car, raceCondition);
        }
    }

    private static void doRace(Car car, Integer raceCondition) {
        if (raceCondition >= 4) {
            car.go();
            return;
        }
        car.stop();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Racing racing = (Racing) o;
        return new HashSet<>(cars).containsAll(racing.cars);
    }

    @Override
    public int hashCode() {
        return cars.hashCode();
    }
}
