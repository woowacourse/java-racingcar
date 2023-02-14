package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("라운드")
class RoundTest {
	@DisplayName("셍성 성공 테스트")
	@Test
	void createSuccessTest() {
		assertDoesNotThrow(() -> new Round(10));
	}

	@DisplayName("다음 넘어가기 성공 테스트")
	@ParameterizedTest(name = "round = {0}")
	@ValueSource(ints = {0, 1, 2, 3, 4})
	void nextRoundTest(int currentRound) {
		Round round = new Round(currentRound);
		Round nextRound = new Round(currentRound + 1);

		round = round.nextRound();

		assertThat(round)
			.usingRecursiveComparison()
			.isEqualTo(nextRound);
	}

	@DisplayName("비교 성공 테스트")
	@ParameterizedTest
	@MethodSource("compareRoundDummy")
	void compareSuccessTest(Round round, Round compareRound, boolean expectedCompareResult) {
		boolean isSameRound = round.isSame(compareRound);
		assertThat(isSameRound).isEqualTo(expectedCompareResult);
	}

	static Stream<Arguments> compareRoundDummy() {
		return Stream.of(
			Arguments.arguments(new Round(0), new Round(0), true),
			Arguments.arguments(new Round(4), new Round(4), true),
			Arguments.arguments(new Round(0), new Round(1), false),
			Arguments.arguments(new Round(4), new Round(2), false)
		);
	}
}