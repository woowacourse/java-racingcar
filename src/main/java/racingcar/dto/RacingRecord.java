package racingcar.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RacingRecord {

    private Map<String, Integer> racingRecord = new LinkedHashMap<>();

    public RacingRecord(Cars cars) {
        for (Car car : cars.getCars()) {
            racingRecord.put(car.getName(), car.getPositionValue());
        }
    }

    public Map<String, Integer> getRacingRecord() {
        return racingRecord;
    }
}
