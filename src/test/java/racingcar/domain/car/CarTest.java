package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.domain.car.Movement.*;
import static racingcar.dummy.TestDataDummy.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차")
class CarTest {
	@DisplayName("생성 성공 테스트")
	@ParameterizedTest(name = "carName = {0}")
	@ValueSource(strings = {"가", "가나", "가나다", "가나다라", "가나다라마"})
	void createCarSuccessTest(String carName) {
		assertDoesNotThrow(() -> new Car(new CarName(carName), MOVE_ZERO_POSITION));
	}

	@DisplayName("이름 공백일 경우 생성 예외 발생 테스트")
	@ParameterizedTest(name = "carName = {0}")
	@NullAndEmptySource
	void createCarNameNullOrBlankExceptionTest(String carName) {
		assertThatThrownBy(() -> new Car(new CarName(carName), MOVE_ZERO_POSITION))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("이름 5글자 초과일 경우 생성 예외 발생 테스트")
	@ParameterizedTest(name = "carName = {0}")
	@ValueSource(strings = {"123456", "1234567", "aaaaaa", "ㅁㅁㅁㅁㅁㅁㅁ"})
	void createCarNameOverLengthExceptionTest(String carName) {
		assertThatThrownBy(() -> new Car(new CarName(carName), MOVE_ZERO_POSITION))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("이동 확인 테스트")
	@ParameterizedTest(name = "movement = {0}")
	@MethodSource("carMovementDummy")
	void moveSuccessTest(Movement movement, Position expectedPosition) {
		final Car car = new Car(CAR_NAME, MOVE_ZERO_POSITION);

		car.move(movement);
		boolean isSamePosition = car.isSamePosition(expectedPosition);

		assertThat(isSamePosition).isTrue();
	}

	static Stream<Arguments> carMovementDummy() {
		return Stream.of(
			Arguments.arguments(MOVE_STOP, MOVE_ZERO_POSITION),
			Arguments.arguments(MOVE_FORWARD, MOVE_FORWARD_ONCE_POSITION)
		);
	}
}