package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Controller.Game;
import racingcar.Model.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 클래스 이름 : GameTest.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class GameTest {
    private List<Car> cars = Arrays.asList(
            new Car("토니", 8),
            new Car("포비", 15),
            new Car("작은곰", 14),
            new Car("보스독", 15)
    );
    private Car topPositionCar = cars.get(1);

    @Test
    @DisplayName("포지션이 가장 큰 차 선별")
    void findTopPositionCar() {
        Car topPositionCar = Game.findTopPositionCar(cars);
        assertThat(topPositionCar).isEqualTo(cars.get(2));
    }

    @Test
    @DisplayName("우승자들 선발")
    void findWinners() {
        for (Car car : cars) {
            topPositionCar.findWinners(car);
        }
        assertThat(Car.winners.toString()).isEqualTo(", 포비, 보스독");
    }
}
