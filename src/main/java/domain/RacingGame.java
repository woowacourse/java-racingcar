package domain;

import java.util.List;

public class RacingGame {

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private int count;

    public RacingGame(final NumberGenerator numberGenerator, final Cars cars, final int count) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
        this.count = count;
    }

    public List<Car> play() {
        cars.move(numberGenerator);
        count--;
        return cars.getCars();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public boolean isPlayable() {
        return count > 0;
    }
}
