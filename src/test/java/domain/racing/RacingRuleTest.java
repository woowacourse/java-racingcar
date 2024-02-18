package domain.racing;

import domain.car.Car;
import domain.random.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRuleTest {
    @DisplayName("레이싱 우승 자동차 목록을 반환한다.")
    @Test
    void findWinnerCars() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 5;
        RacingRule racingRule = new RacingRule();
        List<Car> cars = List.of(
                new Car(randomNumberGenerator, "test1", 0),
                new Car(randomNumberGenerator, "test2", 3),
                new Car(randomNumberGenerator, "test3", 3)
        );

        // When
        List<Car> winners = racingRule.findWinnerCars(cars);

        // Then
        assertThat(winners).hasSize(2);
    }

    @DisplayName("우승자가 없을경우 빈 리스트를 반환한다.")
    @Test
    void getEmptyWinners() throws Exception {
        // Given
        RandomNumberGenerator randomNumberGenerator = (start, end) -> 0;
        RacingRule racingRule = new RacingRule();
        List<Car> cars = List.of(
                new Car(randomNumberGenerator, "test1", 0),
                new Car(randomNumberGenerator, "test2", 0),
                new Car(randomNumberGenerator, "test3", 0)
        );

        // When
        List<Car> winners = racingRule.findWinnerCars(cars);

        // Then
        assertThat(winners).isEmpty();
    }
}
