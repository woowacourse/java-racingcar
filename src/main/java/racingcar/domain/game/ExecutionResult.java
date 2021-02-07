package racingcar.domain.game;

import racingcar.domain.car.CarState;
import racingcar.domain.car.CarStates;
import racingcar.domain.car.CarStatesBuffer;

import java.util.List;

public class ExecutionResult {
    private final List<CarStates> executionResult;

    public ExecutionResult(CarStatesBuffer carStatesBuffer) {
        this.executionResult = carStatesBuffer.getCarStatesLog();
    }

    public List<CarStates> getCarStatesLog() {
        return executionResult;
    }
}
