package racingcar.domain.record;

import racingcar.domain.cars.Cars;

import java.util.List;

public interface RecordManager<T> {
    List<T> makeResults(int gameRound, Cars cars);
}
