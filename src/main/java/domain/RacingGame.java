package domain;

import java.util.List;
import java.util.stream.Collectors;

import output.Outputs;

public class RacingGame {

    private final Cars cars;
    private final RepeatCount repeatCount;

    public RacingGame(Names names, RepeatCount repeatCount) {
        List<Car> cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.cars = new Cars(cars);
        this.repeatCount = repeatCount;
    }

    public boolean canRace() {
        return repeatCount.hasNext();
    }

    public Outputs race() {
        cars.move();
        return Outputs.from(cars);
    }

    public Winners getWinner() {
        return cars.judgeWinners();
    }
}
