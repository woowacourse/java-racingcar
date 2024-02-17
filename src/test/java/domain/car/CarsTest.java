package domain.car;

import domain.racing.RacingRule;
import dto.CarStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("레이스를 진행하고 자동차들의 상태를 반환한다.")
    @Test
    void race() throws Exception {
        // Given
        Cars cars = new Cars(initCars());

        // When
        List<CarStatus> race = cars.race();
        int carADistanceAfterRace = race.get(0).distance();

        // Then
        assertThat(carADistanceAfterRace).isEqualTo(2);
    }

    @DisplayName("우승한 자동차 이름 목록을 반환한다.")
    @Test
    void findWinnerNames() throws Exception {
        // Given
        RacingRule racingRule = new RacingRule();
        Cars cars = new Cars(initCars());

        // When
        List<String> winnerNames = cars.findWinnerNames(racingRule);

        // Then
        assertThat(winnerNames).contains("carA");
    }

    private List<Car> initCars() {
        return List.of(
                new Car((s, e) -> 7, "carA", 1),
                new Car((s, e) -> 0, "carA", 0),
                new Car((s, e) -> 0, "carA", 0),
                new Car((s, e) -> 0, "carA", 0)
        );
    }
}
