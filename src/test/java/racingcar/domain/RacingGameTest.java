package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingGameTest {
	private static Stream<Arguments> createCarsAndRaceResult() {
		return Stream.of(
			Arguments.of(
				List.of(new Car("allen", 5), new Car("pobi", 3))
				, "allen : -----\npobi : ---\n\n"
			)
		);
	}

	@ParameterizedTest
	@MethodSource("createCarsAndRaceResult")
	void 레이스결과_테스트(List<Car> cars, String excepted) {
		assertThat(RacingGame.getRaceResult(cars)).isEqualTo(excepted);
	}
}
