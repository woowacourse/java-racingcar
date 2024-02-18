package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingRuleTest {
    @DisplayName("최대 전진거리의 자동차들을 반환한다.")
    @Test
    void getWinners() {
        // Given
        RacingRule racingRule = new RacingRule();
        Cars cars = new Cars(List.of(
                Car.createCar("test1", 0),
                Car.createCar("test2", 3),
                Car.createCar("test3", 3)));

        // When
        List<Car> winners = racingRule.getWinners(cars);

        // Then
        Assertions.assertThat(winners).hasSize(2);
    }
}
