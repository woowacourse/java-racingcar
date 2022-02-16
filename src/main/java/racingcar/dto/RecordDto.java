package racingcar.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class RecordDto {
    private List<CarDto> racingRecord;

    private RecordDto(List<CarDto> racingRecord) {
        this.racingRecord = racingRecord;
    }

    public static RecordDto createRecordDto(List<Car> cars) {
        return new RecordDto(cars.stream()
            .map(CarDto::from)
            .collect(Collectors.toList()));
    }

    public List<CarDto> getRacingRecord() {
        return Collections.unmodifiableList(racingRecord);
    }
}
