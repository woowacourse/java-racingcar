package racingcar.dto;

import racingcar.validator.DefaultGameRoundValidator;
import racingcar.validator.GameRoundValidator;

public class GameRoundRequest {
    private final int round;

    public GameRoundRequest(String gameRound) {
        GameRoundValidator gameRoundValidator = new DefaultGameRoundValidator();
        gameRoundValidator.validateGameRoundInput(gameRound);

        round = Integer.parseInt(gameRound);
    }

    public int getRound() {
        return round;
    }
}
