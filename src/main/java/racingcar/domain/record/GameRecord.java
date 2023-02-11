package racingcar.domain.record;

import racingcar.domain.cars.Cars;
import racingcar.domain.dto.CarDto;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GameRecord {

    private final Map<Integer, Set<CarDto>> recordsByRound;

    public GameRecord(Map<Integer, Set<CarDto>> recordsByRound) {
        this.recordsByRound = recordsByRound;
    }

    public void record(int gameRound, Cars cars) {
        recordsByRound.put(gameRound, makeCarDtoRecords(cars));
    }

    private Set<CarDto> makeCarDtoRecords(Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toSet());
    }

    public Map<Integer, Set<CarDto>> getRecords() {
        return recordsByRound;
    }
}
