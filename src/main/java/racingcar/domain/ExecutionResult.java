package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResult {
    List<List<CarDTO>> executionResult = new ArrayList<>();

    public void addCurrentExecutionResult(Cars cars) {
        executionResult.add(cars.convertToDTO());
    }

    public List<List<CarDTO>> getExecutionResult() {
        return this.executionResult;
    }

}
