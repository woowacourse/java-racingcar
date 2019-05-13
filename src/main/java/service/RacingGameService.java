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
        Racing racing = new Racing(cars, lapCount);

        return racing.run();
    }

    private static Winners calculatorWinners(Cars cars) {
        GameResult gameResult = new GameResult();

        return gameResult.calculatorWinners(cars);
    }
}
