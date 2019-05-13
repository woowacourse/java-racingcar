package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public String getWinner() {

        List<String> winners;

        Collections.sort(cars, Car::compareTo);
        Car winner = cars.get(0);
        winners = cars.stream().filter(x -> x.isSamePosition(winner))
                .map(x -> x.toString())
                .collect(Collectors.toList());

        return String.join(",", winners);
    }


}
