package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Result {

    private final List<CarState> result;

    private Result(List<CarState> result) {
        this.result = result;
    }

    public static Result from(List<CarState> result) {
        return new Result(result);
    }

    public List<CarState> getCarStates() {
        return Collections.unmodifiableList(result);
    }

    public List<String> getWinners() {
        return result.stream()
            .filter(carState -> isMaxPosition(carState.getPosition()))
            .map(CarState::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return result.stream()
            .mapToInt(CarState::getPosition)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }

    private boolean isMaxPosition(int position) {
        return getMaxPosition() == position;
    }
}
