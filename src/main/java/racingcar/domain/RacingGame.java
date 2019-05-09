package racingcar.domain;

import racingcar.domain.result.RacingGameResult;
import racingcar.domain.result.RacingGameRound;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> carList;
    private final GameCount gameCount;

    public RacingGame(List<Car> carList, GameCount gameCount) {
        this.carList = carList;
        this.gameCount = gameCount;
    }

    public RacingGameResult start() {
        List<RacingGameRound> gameResultDB = new ArrayList<>();
        for (int i = 0; i < gameCount.getGameCount(); i++) {
            proceedOneRound();
            gameResultDB.add(new RacingGameRound(cloneCarList(carList)));
        }
        return new RacingGameResult(gameResultDB);
    }

    private void proceedOneRound() {
        for (Car car : this.carList) {
            car.accelerate();
        }
    }

    private List<Car> cloneCarList(List<Car> carList) {
        return carList.stream().map(car -> {
            try {
                return car.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());
    }
}
