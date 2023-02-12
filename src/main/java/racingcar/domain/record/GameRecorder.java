package racingcar.domain.record;

import racingcar.domain.cars.Cars;

import java.util.Set;

public class GameRecorder {

    private final Set<GameResultOfCar> records;
    private final GameRecordManager gameRecordManager;

    public GameRecorder(Set<GameResultOfCar> records, GameRecordManager gameRecordManager) {
        this.records = records;
        this.gameRecordManager = gameRecordManager;
    }

    public void record(int gameRound, Cars cars) {
        records.addAll(gameRecordManager.makeGameResultsOfCars(gameRound, cars));
    }

    public Set<GameResultOfCar> getRecords() {
        return records;
    }
}
