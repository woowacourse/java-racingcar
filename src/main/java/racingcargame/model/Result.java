package racingcargame.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private List<Car> cars;

    public Result(String[] names) {
        this.cars = Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public List<Car> roundResult() {
        return Round.round(this.cars);
    }

    public List<String> gameResult() {
        return Winner.makeWinner(this.cars);
    }
}
