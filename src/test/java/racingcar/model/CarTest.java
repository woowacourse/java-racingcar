package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

	@Test
	@DisplayName("자동차 생성 시, position 값을 0이 된다.")
	void initCarPosition() {
		Car car = new Car("소주캉");
		assertThat(car.matchPosition(0)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"가나다라마", "가나다라", "가나다", "가나", "가"})
	@DisplayName("자동차 이름이 5글자 이하이면 통과된다.")
	void successNameValidate(String input) {
		Car car = new Car(input);
		assertThat(car.getName()).isEqualTo(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {"소주캉범고래", "여섯글자이름"})
	@DisplayName("자동차 이름이 5글자를 초과하면 에러를 발생시킨다. ")
	void isOverNameLength(String input) {
		assertThatThrownBy(() -> {
			Car car = new Car(input);
		}).isInstanceOf(RuntimeException.class)
				.hasMessageContaining("5글자를 초과했습니다.");
	}

	@Test
	@DisplayName("자동차 이름에 빈 문자열을 입력 시, 에러를 발생시킨다. ")
	void validName() {
		assertThatThrownBy(() -> {
			String input = "";
			Car car = new Car(input);
		}).isInstanceOf(RuntimeException.class)
				.hasMessageContaining("빈 문자열");
	}

	@ParameterizedTest
	@CsvSource(value = {"5:1", "4:1", "3:0", "2:0"}, delimiter = ':')
	@DisplayName("Car move()에 4 이상의 값을 입력 시, 자동차 position이 1 증가한다.")
	void move(int number, int position) {
		Car car = new Car("범고래");
		car.move(number);
		assertThat(car.matchPosition(position)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"5:1", "4:1", "3:0", "2:0"}, delimiter = ':')
	@DisplayName("입력 받은 자동차의 position 값과 비교하여 더 큰 값을 반환한다.")
	void getBiggerPosition(int number, int position) {
		Car car = new Car("범고래");
		car.move(number);
		assertThat(car.getBiggerPosition(0)).isEqualTo(position);
	}
}
