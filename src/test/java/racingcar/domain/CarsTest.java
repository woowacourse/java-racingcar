package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.util.Constant;

class CarsTest {

	@DisplayName("최댓값을 가진 자동차 찾기")
	@Test
	void find_winners() {
		//given
		Cars cars = new Cars(check_ranking_if_correct());
		//when
		List<String> winners = cars.findWinners();
		//then
		assertAll(
			() -> assertThat(winners.size() == 3).isTrue(),
			() -> assertThat(winners).containsExactly("bong", "su", "dal"));
	}

	private List<Car> check_ranking_if_correct() {
		return Arrays.asList(new Car("hee", 2),
			new Car("bong", 3),
			new Car("su", 3),
			new Car("dal", 3),
			new Car("good", 1)
		);
	}

	@DisplayName("자동차 이름 중복 테스트")
	@Test
	void car_name_duplicated() {
		//given, when
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("bong"));
		cars.add(new Car("bong"));
		//then
		assertThatThrownBy(() -> {
			new Cars(cars);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(Constant.CAR_DUPLICATED_ERROR_MESSAGE);
	}

	@DisplayName("자동차 개수 테스트")
	@Test
	void car_count_test() {
		//given, when
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("hee"));
		//then
		assertThatThrownBy(() -> {
			new Cars(cars);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(Constant.CARS_ERROR_MESSAGE);
	}
}