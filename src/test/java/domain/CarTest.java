package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차")
class CarTest {

	@DisplayName("이름 공백 제거 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"hello ", " hello", "h ello", "he  llo"})
	void checkTrimAllBlanks(String input) {
		assertThat(new Car(input).getCarName()).isEqualTo("hello");
	}

	@DisplayName("이름 길이 1 이상 5 이하 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0,false", "1,true", "5,true", "6,false"})
	void checkLength_ShouldBeBetweenOneAndFive(int input, boolean expected) {
		boolean actualValue = input >= 1 && input <= 5;
		assertEquals(expected, actualValue);
	}

	@DisplayName("거리 추가 테스트")
	@Test
	void addDistance() {
		Car car = new Car("kiara");

		Random random = new Random();
		int input = random.nextInt(10);

		car.addDistance(input);
		int expected = car.getDistance();

		if (expected >= 4) {
			assertThat(expected).isEqualTo(1);
		}
	}

	@DisplayName("이름 공백 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"", "    "})
	void checkNull(String input) {
		assertThatThrownBy(() ->
			new Car(input)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("너무 긴 이름 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"ferari", "mercedes"})
	void checkTooLong(String input) {
		assertThatThrownBy(() ->
			new Car(input)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
