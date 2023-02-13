package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

class CarsTest {

    private Car car1;
    private Car car2;
    private Cars cars;

    @BeforeEach
    void init() {
        car1 = new Car("밀리");
        car2 = new Car("밀리밀리");

        car1.move(5);
        car1.move(5);
        car2.move(5);
        cars = new Cars(Arrays.asList(car1, car2));

    }

    @Test
    @DisplayName("게임 결과 확인")
    void getResult() {
        List<String> carsResult = cars.getResult();

        assertAll(
                () -> assertEquals("밀리 : --", carsResult.get(0)),
                () -> assertEquals("밀리밀리 : -", carsResult.get(1))
        );
    }

    @Test
    @DisplayName("최대 위치 찾기")
    void findMaxPosition() {
        int maxPosition = cars.findMaxPosition();

        Assertions.assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 찾기")
    void findWinners() {
        List<Car> winners = cars.findWinners(2);

        Assertions.assertThat(winners).containsExactly(car1);
    }
}
