package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winners {
    private static final int GAP_WITH_SIZE_AND_INDEX = 1;

    private Winners() { }

    public static Winners of(List<Result> results) {
        int lastIndex = results.size() - GAP_WITH_SIZE_AND_INDEX;
        Result result = results.get(lastIndex);
        int maxPosition = getMaxPosition(result);
        return new Winners();
    }

    private static int getMaxPosition(Result result) {
        return result.getCarStates().stream()
                    .mapToInt(CarState::getPosition)
                    .max()
                    .orElseThrow(NoSuchElementException::new);

    }

    private static List<String> getWinners(Result result) {
        List<CarState> carStates = result.getCarStates();
        List<String> winners = carStates.stream()
                .filter(carState -> carState.getPosition() == getMaxPosition(result))
                .map(CarState::getName)
                .collect(Collectors.toList());
        return winners;
    }
}
