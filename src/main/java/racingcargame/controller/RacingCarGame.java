package controller;

import java.util.List;

import racingcargame.domain.car.Car;
import racingcargame.domain.GameLog;
import racingcargame.domain.MovingConditionGenerator;
import racingcargame.domain.RacingCars;
import racingcargame.domain.Repeat;

public class RacingCarGame {

    private RacingCars racingCars;
    private GameLog gameLog = new GameLog();

    public RacingCarGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> run(Repeat repeat, MovingConditionGenerator movingConditionGenerator) {
        processGame(repeat, movingConditionGenerator);
        return racingCars.getWinners();
    }

    private void processGame(Repeat repeat, MovingConditionGenerator movingConditionGenerator) {
        for (int i = 0; i < repeat.getNumber(); i++)
            gameLog.putGameResult(racingCars.processOneRace(movingConditionGenerator));
    }

    public GameLog getGameLog() {
        return gameLog;
    }
}
