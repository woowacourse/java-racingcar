package service;

import model.*;

public class RacingGameService {
    public static GameBoard request(String carNames, String count) {
        Cars cars = new Cars(carNames);
        LapCount lapCount = new LapCount(count);

        LapRecord lapRecord = gameStart(cars, lapCount);
        Winners winners = calculatorWinners(cars);

        return new GameBoard(lapRecord, winners);
    }

    private static LapRecord gameStart(Cars cars, LapCount lapCount) {
        LapRecord lapRecord = new LapRecord();
        Racing racing = new Racing(cars);
        for (int lapNo = 1; lapNo <= lapCount.getLapCount(); lapNo++) {
            racing.run();
            lapRecord.add(cars.copy());
        }

        return lapRecord;
    }

    private static Winners calculatorWinners(Cars cars) {
        GameResult gameResult = new GameResult();
        return gameResult.calculatorWinners(cars);
    }
}
