package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("참여 자동차 도메인 테스트")
class CarsTest {

    @DisplayName("참여 중인 자동차 중 전진 거리가 가장 먼 자동차를 뽑는다.")
    @Test
    void testChooseWinnerCarByPosition() {

        Car winner = Car.of("car4", 4);
        Cars cars = Cars.from(
                List.of(Car.of("car1", 1),
                        Car.of("car2", 2),
                        Car.of("car3", 3),
                        winner));

        List<Car> winners = cars.chooseWinner();

        assertThat(winners).containsExactly(winner);
    }
}