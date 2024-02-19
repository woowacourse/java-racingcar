package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class RoundResultTest {

    @Test
    @DisplayName("자동차의 경주 결과를 기록할 수 있다.")
    void recordRoundResult() {
        List<Car> cars = List.of(
                new Car("pobi", 1),
                new Car("honux", 2),
                new Car("crong", 3)
        );
        RoundResult roundResult = new RoundResult();
        roundResult.recordRoundResult(cars);

        Map<String, Integer> result = roundResult.getRoundResult();

        assertThat(result).containsExactly(entry("pobi", 1), entry("honux", 2), entry("crong", 3));
    }
}
