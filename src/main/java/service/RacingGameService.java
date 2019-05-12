package service;

import model.*;

public class RacingGameService {
    private Cars cars;
    private LapCount lapCount;

    public RacingGameService(String inputCarNames, String lapCount) {
        this.cars = new Cars(inputCarNames);
        this.lapCount = new LapCount(lapCount);
    }

    public LapRecorder run() throws CloneNotSupportedException {
        Racing racing = new Racing(cars);
        LapRecorder lapRecorder = new LapRecorder();

        for (int lapNo = 1; lapNo <= lapCount.getLapCount(); lapNo++) {
            lapRecorder.record(new Cars(racing.run()));
        }

        return lapRecorder;
    }

    public Winners getWinners() {
        GameResult gameResult = new GameResult();
        return gameResult.findWinner(cars);
    }
}
