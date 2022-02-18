package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String MUST_BE_INTEGER = "[ERROR] 시도 횟수는 숫자만 허용됩니다.";
    private static final String MUST_BE_POSITIVE = "[ERROR] 1미만의 시도횟수는 허용되지 않습니다.";

    private Cars cars = new Cars();
    private int totalAttempt = 0;
    private List<ExecutionResult> totalExecutionResult = new ArrayList<>();

    public void initCarNames(String[] names) {
        cars = new Cars(names);
    }

    public void initTotalAttempt(String attempt) {
        validateAttempt(attempt);
        totalAttempt = Integer.parseInt(attempt);
    }

    public void play() {
        while (totalAttempt-- > 0) {
            cars.move();
            totalExecutionResult.add(new ExecutionResult(cars));
        }
    }

    public List<String> selectWinners() {
        return cars.selectWinners();
    }

    public List<ExecutionResult> getTotalExecutionResult() {
        return this.totalExecutionResult;
    }

    private void validateAttempt(String attempt) {
        int num = validateIntegerThenParse(attempt);
        validatePositive(num);
    }

    private int validateIntegerThenParse(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(MUST_BE_INTEGER);
        }
    }

    private void validatePositive(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(MUST_BE_POSITIVE);
        }
    }

}
