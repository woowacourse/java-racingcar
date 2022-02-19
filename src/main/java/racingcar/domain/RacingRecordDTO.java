package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingRecordDTO {
    private final List<CarStatusDTO> racingRecord;

    public RacingRecordDTO(Map<String, Integer> carStatus) {
        this.racingRecord = new ArrayList<>();
        for (Map.Entry<String, Integer> status : carStatus.entrySet()) {
            this.racingRecord.add(new CarStatusDTO(status.getKey(), status.getValue()));
        }
    }

    public List<CarStatusDTO> getRacingRecord() {
        return this.racingRecord;
    }
}
