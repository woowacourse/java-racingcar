package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String MUST_BE_POSITIVE = "[ERROR] 1미만의 시도횟수는 허용되지 않습니다.";

    private Cars cars;
    private int totalAttempt;

    public RacingGame(String[] names, int totalAttempt) {
        this.cars = new Cars(names);

        validateAttempt(totalAttempt);
        this.totalAttempt = totalAttempt;
    }

    public List<ExecutionResult> play() {
        List<ExecutionResult> totalExecutionResult = new ArrayList<>();

        while (totalAttempt-- > 0) {
            cars.move();
            totalExecutionResult.add(cars.generateExecutionResult());
        }

        return totalExecutionResult;
    }

    public List<String> selectWinners() {
        return cars.selectWinners();
    }

    private void validateAttempt(int attempt) {
        if (attempt <= 0) {
            throw new IllegalArgumentException(MUST_BE_POSITIVE);
        }
    }

}
