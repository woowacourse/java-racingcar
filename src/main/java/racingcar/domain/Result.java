package racingcar.domain;

import java.util.List;

public class Result {
    private List<CarState> result;

    private Result(List<CarState> result) {
        this.result = result;
    }

    public static Result of(List<CarState> result) {
        return new Result(result);
    }
}
