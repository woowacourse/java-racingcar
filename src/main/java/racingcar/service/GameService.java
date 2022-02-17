package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.CarStatusDto;
import racingcar.domain.car.Cars;
import racingcar.domain.car.strategy.RandomMoveStrategy;
import racingcar.domain.round.Round;

public class GameService {

    private Cars cars;
    private Round round;

    public void initCarNames(final List<String> carNames) {
        this.cars = new Cars(carNames, new RandomMoveStrategy());
    }

    public void initRound(final int count) {
        this.round = new Round(count);
    }

    public boolean isContinuable() {
        return round.isNotFinished();
    }

    public void playRound() {
        cars.goForwardOrStop();
        round.decreaseCount();
    }

    public List<String> getCurrentStatuses() {
        final List<CarStatusDto> statuses = cars.getStatuses();
        return statuses.stream()
                .map(CarStatusDto::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinnerNames() {
        return cars.getWinnerNames();
    }

}
