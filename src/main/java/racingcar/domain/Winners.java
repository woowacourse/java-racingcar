package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners from(Results results) {
        Result result = results.getLastResult();
        List<CarState> carStates = result.getCarStates();
        List<String> winners = carStates.stream()
            .filter(carState -> results.isMaxPosition(carState.getPosition()))
            .map(CarState::getName)
            .collect(Collectors.toList());
        return new Winners(winners);
    }

    public List<String> toList() {
        return Collections.unmodifiableList(winners);
    }
}
