package racingcar.service;

import java.util.List;

import racingcar.domain.car.strategy.MoveStrategy;
import racingcar.dto.CarStatusDto;
import racingcar.domain.car.Cars;
import racingcar.domain.round.Round;
import racingcar.dto.RoundDto;

public class GameService {

    private final MoveStrategy moveStrategy;

    private Cars cars;
    private Round round;

    public GameService(final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void initCarNames(final List<String> carNames) {
        this.cars = new Cars(carNames, this.moveStrategy);
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

    public List<CarStatusDto> getCurrentStatuses() {
        return cars.getStatuses();
    }

    public List<String> getWinnerNames() {
        return cars.getWinnerNames();
    }

    public RoundDto getCurrentRound() {
        return new RoundDto(round);
    }

}
