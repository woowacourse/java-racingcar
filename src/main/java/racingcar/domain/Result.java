package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Result {
    private final List<Car> result;

    private Result(List<Car> result) {
        this.result = result;
    }

    public static Result of(List<Car> result) {
        return new Result(result);
    }

    public List<Car> getResult() {
        return Collections.unmodifiableList(result);
    }
}
