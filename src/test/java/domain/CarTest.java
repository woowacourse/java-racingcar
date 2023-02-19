package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차는 ")
class CarTest {
	Car car;

	@BeforeEach
	void setUp() {
		car = new Car("benz");
	}

	@DisplayName("이름이 5글자를 초과하면 예외가 발생합니다")
	@ParameterizedTest
	@ValueSource(strings = {"rolls royce", "ferari", "mercedes"})
	void nameOver5(String input) {
		assertThatThrownBy(() -> new Car(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("true일 때 전진합니다")
	void moveForward() {
		car.move(() -> true);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("false일 때 정지합니다")
	void stop() {
		car.move(() -> false);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@DisplayName("이름의 길이가 1 이상 5 이하입니다")
	@ParameterizedTest
	@CsvSource(value = {"0,false", "1,true", "5,true", "6,false"})
	void nameLengthBetween1_5(int input, boolean expected) {
		boolean actualValue = input >= 1 && input <= 5;
		assertEquals(expected, actualValue);
	}
}
