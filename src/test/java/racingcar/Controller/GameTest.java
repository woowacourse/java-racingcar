package racingcar.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;

import java.util.ArrayList;
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
    private List<Car> cars = new ArrayList<>();
    private Car topPositionCar;

	@BeforeEach
	void setUp() {
	    cars.add(new Car("토니", 8));
        cars.add(new Car("포비", 15));
        cars.add(new Car("작은곰", 14));
        cars.add(new Car("보스독", 15));
		topPositionCar = cars.get(1);
	}

	@Test
	@DisplayName("포지션이 가장 큰 차 선별")
    void findTopPositionCar() {
		Game game = new Game(cars, 5);
		Car topPositionCar = game.findTopPositionCar(cars);
		assertThat(topPositionCar).isEqualTo(cars.get(3));
	}

	@Test
	@DisplayName("우승자들 선발")
    void findWinners() {
		for (Car car : cars) {
			topPositionCar.findWinners(car);
		}
		assertThat(topPositionCar.getWinners()).isEqualTo("포비, 보스독");
	}
}
