package racingcar.domain.gamemanager;

import racingcar.controller.dto.GameManagerResponseDto;
import racingcar.domain.round.Round;
import racingcar.domain.car.Cars;
import racingcar.controller.dto.GameManagerRequestDto;

public class GameManager {

    private Cars cars;
    private Round round;

    public GameManager(GameManagerRequestDto requestDto) {
        this.cars = Cars.of(requestDto.getCarNames());
        this.round = Round.of(requestDto.getRound());
    }

    public GameManagerResponseDto playGame() {
        return new GameManagerResponseDto(round.startRace(cars));
    }
}
