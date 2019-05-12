package racingcargame.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private List<Car> cars;

    public Result(String[] names) {
        cars = Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public List<Car> roundResult() {
        return new Round().round(this.cars);
    }

    public String gameResult() {
        return new Winner().makeWinner(this.cars);
    }

}
