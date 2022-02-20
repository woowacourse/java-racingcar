package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Cars.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.Util.Utils;

class CarsTest {
	@Test
	@DisplayName("자동차 목록이 잘 등록되는지 테스트")
	void carsGenerate() {
		String[] carNames = {"pobi", "crong", "huan"};
		Cars cars = new Cars(carNames);
		assertThat(cars.getCars().size()).isEqualTo(carNames.length);
	}

	@Test
	@DisplayName("입력한 이름값이 한개인 경우")
	void onlyName() {
		Assertions.assertThatThrownBy(() -> new Cars(Utils.splitter("pobi")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_ONLY_NAME);
	}

	@Test
	@DisplayName("중복된 이름이 있을 경우")
	void duplicateName() {
		Assertions.assertThatThrownBy(() -> new Cars(Utils.splitter("pobi,pobi")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_DUPLICATE_NAME);
	}

	@Test
	@DisplayName("우승자가 한 명인 경우 테스트")
	void getOneWinner() {
		List<Car> carList = Arrays.asList(
			new Car("pobi", 2),
			new Car("crong", 3),
			new Car("honux", 1)
		);
		Cars cars = new Cars(carList);
		assertThat(cars.getWinners()).contains("crong");
	}

	@Test
	@DisplayName("우승자가 여러명인 경우 테스트")
	void getSeveralWinner() {
		List<Car> carList = Arrays.asList(
			new Car("pobi", 3),
			new Car("crong", 3),
			new Car("honux", 1)
		);
		Cars cars = new Cars(carList);
		assertThat(cars.getWinners().stream()).contains("pobi", "crong");
	}
}