package racingcar.domain.game;

import racingcar.domain.car.CarName;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String DELIMITER = ", ";
    private static final String MESSAGE_GAME_RESULT = "가 최종 우승했습니다.";

    private List<CarName> winners;

    private GameResult(List<CarName> winners) {
        this.winners = winners;
    }

    public static GameResult valueOf(List<CarName> winners) {
        return new GameResult(winners);
    }

    @Override
    public String toString() {
        List<String> winnerNames = winners.stream().map(CarName::toString).collect(Collectors.toList());
        Collections.sort(winnerNames);

        return String.join(DELIMITER, winnerNames) + MESSAGE_GAME_RESULT;
    }
}