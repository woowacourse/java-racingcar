package racingcar.domain.game;

import racingcar.domain.car.CarName;
import racingcar.domain.car.CarStatesBuffer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String DELIMITER = ", ";
    private static final String MESSAGE_GAME_RESULT = "가 최종 우승했습니다.";

    private List<CarName> winners;
    private CarStatesBuffer carStatesBuffer;

    private GameResult(List<CarName> winners, CarStatesBuffer carStateBuffer) {
        this.winners = winners;
        this.carStatesBuffer = carStateBuffer;
    }

    public static GameResult valueOf(List<CarName> winners, CarStatesBuffer carStatesBuffer) {
        return new GameResult(winners, carStatesBuffer);
    }

    public String getWinnersString() {
        List<String> winnerNames = winners.stream().map(CarName::toString).collect(Collectors.toList());
        Collections.sort(winnerNames);

        return String.join(DELIMITER, winnerNames) + MESSAGE_GAME_RESULT;
    }

    public String getExecutionResultString() {
        return carStatesBuffer.toString();
    }
}