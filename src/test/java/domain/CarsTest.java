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

        Car winner = Car.of("car1", 4);
        Cars cars = new Cars(List.of(Car.of("car2", 1),
                Car.of("car3", 2),
                Car.of("car4", 3),
                winner));

        List<Car> winners = cars.chooseWinners();

        assertThat(winners).containsExactly(winner);
    }
}