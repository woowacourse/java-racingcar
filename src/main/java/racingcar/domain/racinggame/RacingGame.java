package racingcar.domain.racinggame;

import racingcar.domain.racingcars.RacingCars;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.gameresult.GameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private static final int MINIMUM_GAME_ROUND = 1;

    private final int gameRound;
    private final NumberGenerator numberGenerator;

    public RacingGame(int gameRound, NumberGenerator numberGenerator) {
        validateGameRound(gameRound);
        this.gameRound = gameRound;
        this.numberGenerator = numberGenerator;
    }

    private void validateGameRound(int gameRound) {
        if (gameRound < MINIMUM_GAME_ROUND) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0 이하 일 수 없습니다.");
        }
    }

    public GameResult startRace(RacingCars racingCars) {
        List<Map<String, Integer>> results = new ArrayList<>();
        for (int i = 0; i < gameRound; i++) {
            results.add(racingCars.moveCars());
        }
        return new GameResult(results);
    }
}
