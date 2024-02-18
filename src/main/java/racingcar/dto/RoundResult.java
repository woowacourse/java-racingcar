package racingcar.dto;

import static java.util.Collections.unmodifiableList;

import java.util.List;

public record RoundResult(List<CarStatus> value) {

    public List<CarStatus> value() {
        return unmodifiableList(value);
    }
}
