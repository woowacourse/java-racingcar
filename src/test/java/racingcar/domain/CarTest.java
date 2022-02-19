package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.strategy.FixedMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;

public class CarTest {

	@Test
	@DisplayName("자동차가 움직일 때 위치는 +1 이 된다")
	public void car_move() {
		// given
		final Car car = Car.builder()
			.position(0)
			.movingStrategy(new FixedMovingStrategy())
			.build();

		final Car movedCar = Car.builder()
			.position(1)
			.build();

		// when & then
		car.move();
		assertThat(car.isSamePosition(movedCar)).isTrue();
	}

	@Test
	@DisplayName("자동차가 움직이지 않을 때 위치는 그대로다")
	public void car_not_move() {
		// given
		final MovingStrategy notMoving = () -> false;

		final Car car = Car.builder()
			.position(0)
			.movingStrategy(notMoving)
			.build();

		final Car notMovedCar = Car.builder()
			.position(0)
			.build();

		// when & then
		car.move();
		assertThat(car.isSamePosition(notMovedCar)).isTrue();
	}

	@Test
	@DisplayName("자동차 이름에 대해 오름차순 정렬이 되는지를 확인한다")
	public void ordering_car_name() {
		// given
		Car car_ef = Car.builder().name("ef").build();
		Car car_hi = Car.builder().name("hi").build();
		Car car_gh = Car.builder().name("gh").build();
		Car car_ab = Car.builder().name("ab").build();
		Car car_cd = Car.builder().name("cd").build();

		List<Car> cars = new ArrayList<>(List.of(car_ef, car_hi, car_gh, car_ab, car_cd));

		// when
		cars.sort(Car::compareNameTo);

		// then
		assertThat(cars).containsExactly(car_ab, car_cd, car_ef, car_gh, car_hi);
	}

	@Test
	@DisplayName("자동차 위치에 대해 오름차순 정렬이 되는지를 확인한다")
	public void ordering_car_position() {
		// given
		Car car_3 = Car.builder().position(3).build();
		Car car_1 = Car.builder().position(1).build();
		Car car_5 = Car.builder().position(5).build();
		Car car_4 = Car.builder().position(4).build();
		Car car_2 = Car.builder().position(2).build();

		List<Car> cars = new ArrayList<>(List.of(car_3, car_1, car_5, car_4, car_2));

		// when
		cars.sort(Car::comparePositionTo);

		// then
		assertThat(cars).containsExactly(car_1, car_2, car_3, car_4, car_5);
	}
}
