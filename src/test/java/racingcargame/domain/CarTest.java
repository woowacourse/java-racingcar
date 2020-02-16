package racingcargame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

	@ParameterizedTest
	@CsvSource(value = {"3:0", "4:1", "5:1", "9:1"}, delimiter = ':')
	void 랜덤값이_4이상_9이하이면_자동차의_position_증가(int input, int expected) {
		Car car = new Car("pobi");
		Engine engine = Engine.createBy(input);
		car.go(engine);
		assertThat(car.getPosition()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"2:pobi", "1:crong", "0:jason", "3:brown"}, delimiter = ':')
	void 자동차_객체_비교로_오름차순_정렬(int index, String expectedName) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("pobi", 5));
		cars.add(new Car("crong", 3));
		cars.add(new Car("jason", 2));
		cars.add(new Car("brown", 7));
		Collections.sort(cars);
		String result = cars.get(index).getName();
		assertThat(result).isEqualTo(expectedName);
	}
}
