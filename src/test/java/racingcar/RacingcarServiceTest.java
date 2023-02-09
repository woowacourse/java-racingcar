package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingcarServiceTest {

    @Test
    @DisplayName("우승자 확인하기")
    void findWinner() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car2.move(5);
        car3.move(5);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        RacingcarService racingcarService = new RacingcarService();
        List<Car> winners = racingcarService.findWinner(cars);

        assertThat(winners).containsExactly(car2, car3);
    }
}