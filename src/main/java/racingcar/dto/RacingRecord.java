package racingcar.dto;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingRecord {

    private Map<String, Integer> racingRecord = new LinkedHashMap<>();

    public RacingRecord(CarsResponse cars) {
        for (CarResponse car : cars.getCars()) {
            racingRecord.put(car.getName(), car.getPosition());
        }
    }

    public Map<String, Integer> getRacingRecord() {
        return racingRecord;
    }
}
