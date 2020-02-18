package racingcargame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.exception.CarsNameInputException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {

	@Test
	void 자동차_이름_미입력() {
		String input = "";
		assertThatThrownBy(() -> {
			Cars.create(input);
		}).isInstanceOf(CarsNameInputException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"aaaaa", "bbbbbbb", "coolime"})
	void 자동차_이름_한개만_입력(String input) {
		assertThatThrownBy(() -> {
			Cars.create(input);
		}).isInstanceOf(CarsNameInputException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"pobi, pobi, crong", "a, b, c, a, b", "11, 111111, 11, 111111"})
	void 자동차_이름이_중복되었을_때(String input) {
		assertThatThrownBy(() -> {
			Cars.create(input);
		}).isInstanceOf(CarsNameInputException.class);
	}

	@Test
	void 자동차_정상생성_확인() {
		Cars cars = Cars.create("pobi, jason, crong");
		List<Car> resultCars = cars.getDeepCopiedCars();
		assertThat(resultCars).hasSize(3);
	}

	@ParameterizedTest
	@CsvSource(value = {"brown:true", "coil:true", "pobi:false"}, delimiter = ':')
	void 최종우승자_추출(String input, boolean expected) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("pobi", 3));
		cars.add(new Car("jason", 1));
		cars.add(new Car("brown", 4));
		cars.add(new Car("coil", 4));
		Cars racingCars = new Cars(cars);
		Winners winners = new Winners(racingCars.extractWinners());
		boolean result = winners.getNames().contains(input);
		assertThat(result).isEqualTo(expected);
	}
}
