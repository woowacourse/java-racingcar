package racingcar.domain.result;

import racingcar.domain.dto.CarDto;

import java.util.Map;
import java.util.Set;

public class Result {

    private final Map<Integer, Set<CarDto>> results;

    public Result(Map<Integer, Set<CarDto>> results) {
        this.results = results;
    }

    public Map<Integer, Set<CarDto>> getResults() {
        return results;
    }
}
