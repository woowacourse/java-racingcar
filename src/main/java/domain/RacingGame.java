package domain;

import java.util.List;
import java.util.stream.Collectors;

import output.Outputs;

public class RacingGame {

    private static final int MOVED_LOWER_BOUND = 4;

    private final Cars cars;
    private final RepeatCount repeatCount;
    private final RandomGenerator randomGenerator;

    public RacingGame(Names names, RepeatCount repeatCount, RandomGenerator randomGenerator) {
        List<Car> cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.cars = new Cars(cars);
        this.repeatCount = repeatCount;
        this.randomGenerator = randomGenerator;
    }

    public boolean canRace() {
        return repeatCount.hasNext();
    }

    public Outputs race() {
        List<Car> cars = this.cars.getCars();
        cars.forEach(this::move);

        return Outputs.from(this.cars);
    }

    private void move(Car car) {
        if (randomGenerator.generate() >= MOVED_LOWER_BOUND) {
            car.move();
        }
    }

    public Winners getWinner() {
        return cars.judgeWinners();
    }
}
