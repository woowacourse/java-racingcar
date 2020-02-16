package racingcargame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcargame.domain.car.Car;

public class CarNameTest {

	@ParameterizedTest
	@DisplayName("이름이 올바른지 확인")
	@ValueSource(strings = {"abcdef", ""})
	void lengthTest(String name) {
		assertThatThrownBy(() -> new Car(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 1자 이상 5자 이하로 해주세요.");
	}

	@Test
	@DisplayName("이름에 null값이 온 경우")
	void nullTest() {
		assertThatThrownBy(() -> new Car(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 null값이 될 수 없습니다.");
	}

	@Test
	@DisplayName("이름에 공백이 포함된 경우")
	void blankTest() {
		assertThatThrownBy(() -> new Car("ab c"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름에는 공백이 포함될 수 없습니다.");
	}
}
