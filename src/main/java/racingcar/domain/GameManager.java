package racingcar.domain;

import racingcar.domain.dto.GameManagerRequestDto;

public class GameManager {
    private Cars cars;
    private Round round;

    public void playGame(GameManagerRequestDto requestDto) {
        String[] carNames = requestDto.getCarNames();
        this.cars = Cars.of(carNames);
        this.round = Round.of(requestDto.getRound());
    }
}
