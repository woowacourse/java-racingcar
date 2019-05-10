package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final MovementStrategy strategy = new RandomMovement();
    private final List<Car> cars = new ArrayList<>();
    private int cursor = -1;

    public Race(List<String> names){
        System.out.println(names);
        validateNames(names);
        names.forEach(name -> cars.add(new Car(name)));
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
        if (names.size() < 2) {
            throw new IllegalArgumentException("2개 이상의 이름 필요");
        }
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException("중복된 이름 불가");
        }
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    /*
    자동차 대수를 주기로 순서대로 진행함
     */
    public Car startRound() {
        cursor = (cursor + 1) % cars.size();
        return cars.get(cursor).moveOrStop(strategy);
    }

    public List<Car> getWinners() {
        Collections.sort(cars);
        Car winner = cars.get(0);
        return cars.stream().filter(x -> x.isAtSamePositionWith(winner)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        return ((Race)obj).cars.equals(this.cars);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cars == null) ? 0 : cars.hashCode());
        result = prime * result + cursor;
        return result;
    }
}