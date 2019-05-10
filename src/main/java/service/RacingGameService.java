package service;

import model.*;

public class RacingGameService {
    Cars cars;
    LapCount lapCount;

    public RacingGameService(String carNames, String lapCount) {
        this.cars = new Cars(carNames);
        this.lapCount = new LapCount(lapCount);
    }

    public LapRepository run() {
        try {
            LapRepository lapRepository = new LapRepository();
            Racing racing = new Racing(cars);
            for (int lapNo = 1; lapNo <= lapCount.getLapCount(); lapNo++) {
                racing.run();
                lapRepository.add(cars.clone());
            }
            return lapRepository;
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Winners getWinners() {
        GameResult gameResult = new GameResult();
        return gameResult.calculator(cars);
    }
}
