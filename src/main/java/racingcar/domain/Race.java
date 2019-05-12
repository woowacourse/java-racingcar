package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final MovementStrategy strategy = new RandomMovement();
    private final List<Car> cars = new ArrayList<>();
    //private int cursor = 0;
    private RoundResult roundResult = new RoundResult();

    public Race(List<String> names) {
        validateNames(names);
        names.forEach(name -> cars.add(new Car(name)));
        cars.forEach(car -> roundResult.addParticipant(car));
        Collections.unmodifiableCollection(cars);
    }

    /*
    Test에서 사용하기 위한 생성자
     */
    public Race(List<Car> cars, boolean foobar) { //타입 겹침 회피용
        cars.forEach(car -> this.cars.add(car));
        Collections.unmodifiableCollection(cars);
    }

    private void validateNames(List<String> names) {
        if (names.size() < 2 || names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException();
        }
    }

    public RoundResult startRound() {
        for (Car car : cars) {
            if (car.moveOrStop(strategy)) {
                roundResult.updateResult(car);
            }
        }
        return roundResult;
    }

    public List<Car> getWinners() {
        Collections.sort(cars);
        Car winner = cars.get(0);
        return cars.stream().filter(x -> x.isAtSamePositionWith(winner)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        return ((Race) obj).cars.equals(this.cars);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cars == null) ? 0 : cars.hashCode());
        result = prime * result + strategy.hashCode();
        return result;
    }
}