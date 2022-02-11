package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingRecord {
    private List<Car> racingRecord;

    public RacingRecord(List<Car> driveRecord) {
        this.racingRecord = driveRecord;
    }

    public List<Car> getRacingRecord() {
        return Collections.unmodifiableList(racingRecord);
    }
}
