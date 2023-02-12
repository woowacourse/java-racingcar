package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("위치 ")
class PositionTest {
	@DisplayName("기본 생성 성공 테스트")
	@Test
	void createDefaultSuccessTest() {
		assertDoesNotThrow(() -> new Position());
	}

	@DisplayName("생성 성공 테스트")
	@Test
	void createSuccessTest() {
		assertDoesNotThrow(() -> new Position(1));
	}

	@DisplayName("이동 후 거리 확인 성공 테스트")
	@ParameterizedTest
	@MethodSource("moveSuccessDummy")
	void moveSuccessTest(Position currentPosition, Position movePosition, Position expectedPosition) {
		currentPosition = currentPosition.move(movePosition);
		boolean isSamePosition = currentPosition.isSame(expectedPosition);

		assertThat(isSamePosition).isTrue();
	}

	static Stream<Arguments> moveSuccessDummy() {
		return Stream.of(
			Arguments.arguments(new Position(), new Position(10), new Position(10)),
			Arguments.arguments(new Position(1), new Position(11), new Position(12)),
			Arguments.arguments(new Position(32), new Position(5), new Position(37))
		);
	}
}