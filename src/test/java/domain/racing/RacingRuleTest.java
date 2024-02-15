package domain.racing;

import domain.car.Car;
import domain.car.Cars;
import domain.random.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingRuleTest {
    @DisplayName("최대 전진거리의 자동차들을 반환한다.")
    @Test
    void getWinners() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 5;
        RacingRule racingRule = new RacingRule();
        Cars cars = new Cars(List.of
                (new Car(randomNumberGenerator, "test1", 0),
                        new Car(randomNumberGenerator, "test2", 3),
                        new Car(randomNumberGenerator, "test3", 3)));

        // When
        List<Car> winners = racingRule.getWinners(cars);

        // Then
        Assertions.assertThat(winners).hasSize(2);
    }
}
