package racingcar.domain;

import java.util.Map;

public class Result {
    private Map<String, Integer> result;

    private Result(Map<String, Integer> result) {
        this.result = result;
    }

    private static Result of(Map<String, Integer> result) {
        return new Result(result);
    }
}
