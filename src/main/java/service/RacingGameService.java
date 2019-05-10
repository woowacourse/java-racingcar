package service;

import model.Cars;
import model.GameResult;
import model.LapCount;
import model.Racing;

public class RacingGameService {
    Cars cars;
    LapCount lapCount;

    public RacingGameService(String carNames, String lapCount) {
        this.cars = new Cars(carNames);
        this.lapCount = new LapCount(lapCount);
    }

    public String run() {
        StringBuilder sb = new StringBuilder();
        Racing racing = new Racing(cars);

        for (int lapNo = 1; lapNo <= lapCount.getLapCount(); lapNo++) {
            racing.run();
            sb.append(cars.toString());
        }

        return sb.toString();
    }

    public String getWinners() {
        GameResult gameResult = new GameResult(cars);
        return gameResult.getWinners().toString();
    }
}
