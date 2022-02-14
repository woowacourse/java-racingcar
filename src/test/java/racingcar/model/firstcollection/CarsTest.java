package racingcar.model.firstcollection;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import racingcar.model.vo.Car;

public class CarsTest {
	private List<Car> cars;

	@BeforeEach
	void setup() {
		cars = new ArrayList<>();
		cars.add(new Car("pobi"));
		cars.add(new Car("hoho"));
		cars.add(new Car("rich"));
	}

	@ParameterizedTest(name = "new Cars({0})")
	@NullAndEmptySource
	@DisplayName("new Cars()에 Null, Empty 전달 시 IAE발생")
	void validateNullOrEmpty(List<Car> cars) {
		assertThatThrownBy(() -> new Cars(cars))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageMatching("자동차 목록을 확인해주세요");
	}

	@Test
	@DisplayName("new Car()중 중복된 자동차 있을 시 IAE발생")
	void validateDuplicateCar() {
		// given
		cars.add(new Car("rich"));

		// when & then
		assertThatThrownBy(() -> new Cars(cars))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("이름은 중복될 수 없습니다.");
	}

	@Test
	@DisplayName("우승자 목록 가져오기")
	void getWinnerTest() {
		// given
		Car winner = cars.get(0);
		winner.advance(() -> true);
		String expected = winner.getName();

		// when
		Cars cars = new Cars(this.cars);
		List<String> winnerNames = cars.getWinner();

		// when & then
		assertThat(winnerNames.size() == 1 && winnerNames.get(0).equals(expected)).isTrue();
	}

	@Test
	@DisplayName("List<Car> 불면 확인")
	void carsShouldNotBeChanged() {
		// given
		Cars cars = new Cars(this.cars);

		// when
		List<Car> unmodifiableCars = cars.getCars();

		// when & then
		assertThatThrownBy(() -> unmodifiableCars.add(new Car("poki")))
			.isInstanceOf(UnsupportedOperationException.class);
	}
}
