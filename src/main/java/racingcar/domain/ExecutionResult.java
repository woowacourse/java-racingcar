package racingcar.domain;

import java.util.Set;
import java.util.Map;

public class ExecutionResult {
    Map<String, Integer> executionResult;

    public ExecutionResult(Set<Car> cars) {
        for (Car car : cars) {
            executionResult.put(car.getName(), car.getPosition());
        }
    }

    public Map<String, Integer> getExecutionResult() {
        return this.executionResult;
    }

}
