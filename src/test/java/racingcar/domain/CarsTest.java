package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	private List<Car> cars;

	@BeforeEach
	void init() {
		String[] names = "car1,car2,car3".split(",");
		cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name.trim()));
		}
	}

	@DisplayName("자동차 랜덤 숫자 범위 확인")
	@Test
	void cars_random_range() {
		//given, when
		int value = generate();
		//then
		assertTrue(value > -1 && value < 11);
	}

	@DisplayName("이동거리 최댓값을 가지는 Car 찾기")
	@Test
	void cars_max_position_car() {
		//given
		setPositionCars();
		//when
		Car maxMoveCar = findMaxPositionCar();
		//then
		assertTrue(maxMoveCar.getPosition() == 2);
	}

	@DisplayName("공동 승리")
	@Test
	void cars_winners() {
		//given
		setPositionCars();
		//when
		Car maxMoveCar = findMaxPositionCar();
		List<String> winners = findSamePositionCar(maxMoveCar);
		//then
		assertThat(winners).containsExactly("car1", "car2");
	}

	void setPositionCars() {
		int[] moveList = {0, 0, 1, 1, 2};
		for (int i : moveList) {
			cars.get(i).drive(true);
		}
	}

	private int generate() {
		return (int)(Math.random() * 100) % 10;
	}

	private Car findMaxPositionCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new NoSuchElementException("max 값을 찾을 수 없습니다."));
	}

	private List<String> findSamePositionCar(Car target) {
		return cars.stream()
			.filter(car -> car.isSamePosition(target))
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}