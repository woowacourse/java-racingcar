package service;

import model.*;

public class RacingGameService {
    private Cars cars;
    private LapCount lapCount;

    public RacingGameService(String carNames, String lapCount) {
        this.cars = new Cars(carNames);
        this.lapCount = new LapCount(lapCount);
    }

    public LapRecord run() {
        LapRecord lapRecord = new LapRecord();
        Racing racing = new Racing(cars);
        for (int lapNo = 1; lapNo <= lapCount.getLapCount(); lapNo++) {
            racing.run();
            lapRecord.add(cars.copy());
        }
        return lapRecord;
    }

    public Winners getWinners() {
        GameResult gameResult = new GameResult();
        return gameResult.calculator(cars);
    }
}
