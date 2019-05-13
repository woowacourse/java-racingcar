package racingcargame.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private final List<Car> cars;

    public Result(String[] names) {
        this.cars = Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public Round roundResult() {
        return new Round(this.cars);
    }

    public Winner gameResult() {
        return new Winner(this.cars);
    }
}
