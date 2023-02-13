package racingcar.domain.record;

import racingcar.domain.cars.Cars;

import java.util.List;

public class GameRecorder {

    private final List<GameResultOfCar> records;
    private final GameRecordManager gameRecordManager;

    public GameRecorder(List<GameResultOfCar> records, GameRecordManager gameRecordManager) {
        this.records = records;
        this.gameRecordManager = gameRecordManager;
    }

    public void record(int gameRound, Cars cars) {
        records.addAll(gameRecordManager.makeGameResultsOfCars(gameRound, cars));
    }

    public List<GameResultOfCar> getRecords() {
        return records;
    }
}
