package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.dto.CarDto;

public class CarsTest {
	@DisplayName("경주 진행")
	@Test
	void race() {
		Cars cars = Cars.create();
		cars.add(Car.of("car1", 0));
		cars.add(Car.of("car2", 0));
		cars.add(Car.of("car3", 0));
		cars.race((min, max) -> 4);
		for (CarDto carInformation : cars.getCarsDto()) {
			assertThat(carInformation.getPosition()).isEqualTo(1);
		}
	}

	@DisplayName("Car의 DTO 리스트를 반환한다.")
	@Test
	void getCarsDto() {
		Cars cars = Cars.create();
		cars.add(Car.of("car1", 2));
		cars.add(Car.of("car2", 3));
		cars.add(Car.of("car3", 8));
		assertThat(cars.getCarsDto().size()).isEqualTo(3);
	}

	@Test
	void 위치와_일치하는_자동차의_리스트를_가져온다() {
		Cars cars = Cars.create();
		cars.add(Car.of("car1", 2));
		cars.add(Car.of("car2", 3));
		cars.add(Car.of("car3", 8));
		cars.add(Car.of("car4", 11));
		cars.add(Car.of("car5", 11));

		assertThat(cars.getCarsByPosition(Position.from(11)))
			.contains(Car.from("car4"), Car.from("car5"));
	}

	@DisplayName("getWinnerNames 메소드는")
	@Test
	void 우승자들의_이름을_반환한다() {
		Cars cars = Cars.create();
		cars.add(Car.of("car1", 5));
		cars.add(Car.of("car2", 3));
		cars.add(Car.of("car3", 5));

		assertThat(cars.getWinnersNames().toString()).isEqualTo("car1, car3");
	}

	@DisplayName("getFirstPosition 메소드는")
	@Nested
	class GetFirstPosition {
		@Test
		void 가장_멀리간_차의_위치를_가져온다() {
			Cars cars = Cars.create();
			cars.add(Car.of("car1", 5));
			cars.add(Car.of("car2", 3));
			cars.add(Car.of("car3", 8));

			assertThat(cars.getFirstPosition())
				.isEqualTo(Position.from(8));
		}

		@Test
		void 아무_차가_없다면() {
			Cars cars = Cars.create();
			assertThatThrownBy(cars::getFirstPosition)
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@DisplayName("add 메소드는")
	@Nested
	class Add {
		@Test
		void 중복_이름이_입력되었다면() {
			Cars cars = Cars.create();
			cars.add(Car.from("car1"));

			assertThatThrownBy(() -> cars.add(Car.from("car1")))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		void 중복_이름이_입력되지았다면() {
			Cars cars = Cars.create();
			cars.add(Car.from("car1"));

			assertDoesNotThrow(() -> cars.add(Car.from("car2")));
		}
	}
}
