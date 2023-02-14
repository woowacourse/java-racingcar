package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MovableStrategy;
import racingcar.strategy.MovingStrategy;

class CarsTest {

    private Car car1;
    private Car car2;
    private Cars cars;
    private MovingStrategy movableStrategy = new MovableStrategy();

    @BeforeEach
    void init() {
        car1 = new Car("밀리", 0);
        car2 = new Car("밀리밀리", 0);

        car1.move(movableStrategy);
        car1.move(movableStrategy);
        car2.move(movableStrategy);
        cars = new Cars(Arrays.asList(car1, car2));

    }

    @Test
    @DisplayName("게임 결과 확인")
    void getResult() {
        List<String> carsResult = cars.getResult("-");

        assertAll(
                () -> assertEquals("밀리 : --", carsResult.get(0)),
                () -> assertEquals("밀리밀리 : -", carsResult.get(1))
        );
    }

    @Test
    @DisplayName("우승자 찾기")
    void findWinners() {
        List<Car> winners = cars.findWinners();

        Assertions.assertThat(winners).containsExactly(car1);
    }
}
