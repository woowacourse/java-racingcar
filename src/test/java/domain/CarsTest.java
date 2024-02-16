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

        Car winner = new Car("car4", 4);
        Cars cars = Cars.from(
                List.of(new Car("car4", 1),
                        new Car("car4", 2),
                        new Car("car4", 3),
                        winner));

        List<Car> winners = cars.chooseWinners();

        assertThat(winners).containsExactly(winner);
    }
}