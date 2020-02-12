package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.Game;
import racingcar.Model.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    private Car topPositionCar = new Car("포비", 15);
    private List<Car> cars = Arrays.asList(
            new Car("토니", 8),
            new Car("작은곰", 14),
            new Car("보스독", 15)
    );

    @Test
    @DisplayName("포지션이 가장 큰 차 선별")
    void findTopPositionCar() {
        Car topPositionCar = Game.findTopPositionCar(cars);
        assertThat(topPositionCar).isEqualTo(cars.get(2));
    }
}
