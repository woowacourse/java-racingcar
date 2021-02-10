package racingcar.domain;

import racingcar.domain.car.Cars;
import racingcar.domain.dto.GameManagerRequestDto;
import racingcar.domain.result.Results;

public class GameManager {

    private Cars cars;
    private Round round;

    public Results playGame(GameManagerRequestDto requestDto) {
        initSet(requestDto);
        return round.startRace(cars);
    }

    private void initSet(GameManagerRequestDto requestDto) {
        this.cars = Cars.of(requestDto.getCarNames());
        this.round = Round.of(requestDto.getRound());
    }
}
