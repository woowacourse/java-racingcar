package racingcar.domain;

import racingcar.domain.result.RacingGameResult;
import racingcar.domain.result.RacingGameRound;
import racingcar.utils.CloneUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_NUM_SCOPE = 10;
    public static final int MIN_NUM_OF_CARS_FOR_GAME = 2;
    private final List<Car> cars;
    private final GameCount gameCount;

    public RacingGame(List<Car> cars, GameCount gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public RacingGameResult start() {
        List<RacingGameRound> gameResultDB = new ArrayList<>();
        for (int i = 0; i < gameCount.getGameCount(); i++) {
            proceedOneRound();
            gameResultDB.add(new RacingGameRound(CloneUtils.copyAllCars(cars)));
        }
        return new RacingGameResult(gameResultDB);
    }

    private void proceedOneRound() {
        for (Car car : this.cars) {
            car.accelerate(generateRandomNum(RANDOM_NUM_SCOPE));
        }
    }

    private int generateRandomNum(int scope) {
        return new Random().nextInt(scope);
    }
}
