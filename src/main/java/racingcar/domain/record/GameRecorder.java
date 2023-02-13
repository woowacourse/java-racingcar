package racingcar.domain.record;

import racingcar.domain.cars.Cars;
import racingcar.domain.result.GameResultOfCar;

import java.util.List;

public class GameRecorder {

    private final List<GameResultOfCar> records;
    private final RecordManager<GameResultOfCar> recordManager;

    public GameRecorder(List<GameResultOfCar> records, RecordManager<GameResultOfCar> recordManager) {
        this.records = records;
        this.recordManager = recordManager;
    }

    public void record(int gameRound, Cars cars) {
        records.addAll(recordManager.makeResults(gameRound, cars));
    }

    public List<GameResultOfCar> getRecords() {
        return records;
    }
}
