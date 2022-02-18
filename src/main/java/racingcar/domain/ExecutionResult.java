package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResult {
    List<CarDTO> executionResult = new ArrayList<>();

    public ExecutionResult(Cars cars) {
        for (Car car : cars.getCars()) {
            executionResult.add(new CarDTO(car));
        }
    }

    public List<CarDTO> getExecutionResult() {
        return this.executionResult;
    }

}
