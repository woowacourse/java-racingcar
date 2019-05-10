package racingcargame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private List<Car> cars = new ArrayList<>();

    public Result(String[] names) {
        Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public List<Car> roundResult() {
        return new Round().round(this.cars);
    }

    public List<String> gameResult() {
        return new Winner().makeWinner(this.cars);
    }

}
