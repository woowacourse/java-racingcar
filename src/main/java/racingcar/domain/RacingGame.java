package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final Count count;

    public RacingGame(final NumberGenerator numberGenerator, final Cars cars, final Count count) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
        this.count = count;
    }

    public void play() {
        cars.move(numberGenerator);
        count.decrease();
    }

    public List<Car> getCurrentResult() {
        return cars.getCars();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public boolean isPlayable() {
        return count.isPlayable();
    }
}
