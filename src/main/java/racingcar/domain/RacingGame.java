package racingcar.domain;

import racingcar.domain.result.RacingGameResult;
import racingcar.domain.result.RacingGameRound;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static final int MIN_NUM_OF_CARS_FOR_GAME = 2;

    private final List<Car> cars;
    private final GameCount gameCount;

    public RacingGame(List<Car> cars, GameCount gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public RacingGameResult start() {
        List<RacingGameRound> gameRounds = new ArrayList<>();
        for (int i = 0; i < gameCount.getGameCount(); i++) {
            proceedOneRound();
            gameRounds.add(new RacingGameRound(cloneCarList(cars)));
        }
        return new RacingGameResult(gameRounds);
    }

    private void proceedOneRound() {
        for (Car car : this.cars) {
            car.accelerate();
        }
    }

    private static List<Car> cloneCarList(List<Car> cars) {
        return cars.stream().map(car -> {
            try {
                return car.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("내부 에러 발생. 다시 실행해주세요.");
            }
        }).collect(Collectors.toList());
    }
}
