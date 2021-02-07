package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winners {
    private static final int GAP_WITH_SIZE_AND_INDEX = 1;

    private final List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners of(List<Result> results) {
        int lastIndex = results.size() - GAP_WITH_SIZE_AND_INDEX;
        Result result = results.get(lastIndex);
        List<CarState> carStates = result.getCarStates();
        List<String> winners = carStates.stream()
                .filter(carState -> carState.isMaxPosition(getMaxPosition(result)))
                .map(CarState::getName)
                .collect(Collectors.toList());
        return new Winners(winners);
    }

    private static int getMaxPosition(Result result) {
        return result.getCarStates().stream()
                .mapToInt(CarState::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
