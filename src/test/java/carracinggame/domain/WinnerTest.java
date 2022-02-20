package carracinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @DisplayName("자동차 경주 우승자 선정 결과 테스트")
    @Test
    void testWinners() {
        List<Car> cars = new ArrayList<>();
        List<Car> winners = new ArrayList<>();

        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        car1.move(5);
        car2.move(5);

        winners.add(car1);
        winners.add(car2);

        Winner winner = new Winner();
        List<Car> result = winner.findWinner(cars);

        assertThat(result).isEqualTo(winners);
    }
}
