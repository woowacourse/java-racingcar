package carracing.model;

import static carracing.model.CarExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import carracing.util.MovableNumberGenerator;
import carracing.utils.NumberGenerator;

public class CarsTest {
	Car eastCar;
	Car pobiCar;
	Car peperCar;

	@BeforeEach
	void car_init() {
		eastCar = Car.nameOf("east");
		pobiCar = Car.nameOf("pobi");
		peperCar = Car.nameOf("peper");
	}

	@Test
	@DisplayName("자동차의 이름이 중복될 경우 에러 발생")
	void validate_자동차이름_중복() {
		//given
		//when
		//then
		assertThatThrownBy(() -> {
			Cars cars = new Cars(Arrays.asList(
				pobiCar,
				eastCar,
				peperCar,
				Car.nameOf("east")
			));
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NAME_DUPLICATE_EXCEPTION.getMessage());
	}

	@Test
	@DisplayName("position이 가장 높은 자동차가 우승")
	void 최종우승자_결정_한명() {
		//given
		move(pobiCar, 1);
		move(eastCar, 2);
		move(peperCar, 3);

		Cars cars = new Cars(Arrays.asList(
			pobiCar, eastCar, peperCar
		));
		//when

		//then
		List<String> winners = convertWinnersToStringList(cars.getWinners());
		assertThat(winners).contains("peper");
	}

	@Test
	@DisplayName("position이 가장 높은 자동차가 두 대일 때 공동 우승자")
	public void 최종우승자_결정_여러명() throws Exception {
		//given
		move(pobiCar, 1);
		move(eastCar, 3);
		move(peperCar, 3);

		Cars cars = new Cars(Arrays.asList(
			pobiCar, eastCar, peperCar
		));
		// when
		// then
		List<String> winners = convertWinnersToStringList(cars.getWinners());
		assertThat(winners).contains("peper", "east");
	}

	void move(Car car, int cnt) {
		final NumberGenerator numberGenerator = new MovableNumberGenerator();
		while ((cnt--) > 0) {
			car.move(numberGenerator);
		}
	}

	List<String> convertWinnersToStringList(List<Car> winners){
		return winners.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
