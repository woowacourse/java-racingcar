package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class RacingCarGame {
    private final Cars cars;
    private final Count count;

    public RacingCarGame(Cars cars, Count count) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. Cars 타입을 이용하세요.");
        }
        if (Objects.isNull(count)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. Count 타입을 이용하세요.");
        }

        this.cars = cars;
        this.count = count;
    }

    public void playRound() {
        cars.attemptToMoveCars();
        count.decrease();
    }

    public boolean canPlay() {
        return count.hasRemaining();
    }

    public List<Car> getWinners() {
        if (canPlay()) {
            throw new IllegalStateException("게임이 끝나지 않았습니다.");
        }
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.get();
    }
}
