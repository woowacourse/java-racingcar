package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final MovementStrategy strategy = new RandomMovement();
    private final List<Car> cars;
    private RoundResult roundResult = new RoundResult();

    public Race(List<String> names) {
        validateNames(names);
        this.cars = Collections.unmodifiableList(
                names.stream().map(name -> new Car(name)).collect(Collectors.toList())
        );
        cars.forEach(car -> roundResult.addParticipant(car));
    }

    /*
    Test에서 사용하기 위한 생성자
     */
    public Race(List<Car> cars, boolean foobar) { //타입 겹침 회피용
        this.cars = Collections.unmodifiableList(cars);
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
        List<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars);
        Car winner = sortedCars.get(0);
        return sortedCars.stream().filter(x -> x.isAtSamePositionWith(winner)).collect(Collectors.toList());
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