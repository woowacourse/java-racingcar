package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.config.CarMovementConfig.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
	NumberGenerator numberGenerator;
	CarMovement carMovement;

	@BeforeEach
	void setUp() {
		numberGenerator = new RandomNumberGenerator();
		carMovement = new CarMovement(numberGenerator);
	}

	@DisplayName("자동차 생성 성공 테스트")
	@ParameterizedTest(name = "carName = {0}")
	@MethodSource("carNameDummy")
	void createCarSuccessTest(String carName) {
		assertDoesNotThrow(() -> new Car(carMovement, carName));
	}

	@DisplayName("자동차 이름 공백일 경우 생성 예외 테스트")
	@ParameterizedTest(name = "carName = {0}")
	@NullAndEmptySource
	void createCarNameNullOrBlankExceptionTest(String carName) {
		assertThatThrownBy(() -> new Car(carMovement, carName))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이름 다섯 글자 이상일 경우 생성 예외 테스트")
	@ParameterizedTest(name = "carName = {0}")
	@ValueSource(strings = {"123456", "1234567", "aaaaaa", "ㅁㅁㅁㅁㅁㅁㅁ"})
	void createCarNameOverLengthExceptionTest(String carName) {
		assertThatThrownBy(() -> new Car(carMovement, carName))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이동 성공 테스트")
	@Test
	void moveSuccessTest() {
		carMovement = new CarMovement(MOVE_FORWARD_MIN_NUMBER::getNumber);
		Car car = new Car(carMovement, "헤나");

		boolean isCarMoved = car.move();

		assertThat(isCarMoved).isTrue();
	}

	static Stream<Arguments> carNameDummy() {
		return Stream.of(
			Arguments.arguments("가"),
			Arguments.arguments("가나"),
			Arguments.arguments("가나다"),
			Arguments.arguments("가나다라"),
			Arguments.arguments("가나다라마")
		);
	}
}