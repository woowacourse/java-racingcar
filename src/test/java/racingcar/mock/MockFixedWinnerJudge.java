package racingcar.mock;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.WinnerJudge;

import java.util.List;

public class MockFixedWinnerJudge extends WinnerJudge {

    private final List<Car> winners;

    private MockFixedWinnerJudge(final List<Car> winners) {
        this.winners = winners;
    }

    public static MockFixedWinnerJudge withWinners(final List<Car> winners) {
        return new MockFixedWinnerJudge(winners);
    }

    @Override
    public List<Car> judge(final Cars cars) {
        return winners;
    }
}
