package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.exception.car.CarNameDuplicatedException;
import racingcar.exception.car.CarNameEmptyException;
import racingcar.exception.car.CarNameTooLongException;

public class CarCollectionTest {

	private void exceptionTest(Class throwableClass, List<String> carNames) {
		assertThrows(throwableClass, () -> new CarCollection(carNames)
		);
	}

	@ParameterizedTest
	@MethodSource("provideValuesForLengthException")
	void 자동차이름_길이_예외처리(List<String> names) {
		exceptionTest(CarNameTooLongException.class, names);
	}

	public static Stream<Arguments> provideValuesForLengthException() {
		return Stream.of(
			Arguments.of(Arrays.asList("slow", "if", "hanull")),
			Arguments.of(Arrays.asList("sinb57", "slow", "if")),
			Arguments.of(Arrays.asList("sinb57", "slow", "if", "hanull"))
		);
	}

	@ParameterizedTest
	@MethodSource("provideValuesForEmptyException")
	void 자동차이름_공백_예외처리(List<String> names) {
		exceptionTest(CarNameEmptyException.class, names);
	}

	public static Stream<Arguments> provideValuesForEmptyException() {
		return Stream.of(
				Arguments.of(Arrays.asList("")),
				Arguments.of(Arrays.asList("if", "hanul", ""))
		);
	}

	@ParameterizedTest
	@MethodSource("provideValuesForDuplicateException")
	void 자동차이름_중복_예외처리(List<String> names) {
		exceptionTest(CarNameDuplicatedException.class, names);
	}

	public static Stream<Arguments> provideValuesForDuplicateException() {
		return Stream.of(
			Arguments.of(Arrays.asList("slow", "if", "slow")),
			Arguments.of(Arrays.asList("slow", "if", "test", "test")));
	}

	@Test
	void 전진_조건이_만족할_때_자동자_전진() {
		CarCollection carCollection = new CarCollection(
			Arrays.asList("slow", "if", "poby")
		);
		CustomNumberPicker customNumberPicker = new CustomNumberPicker(
			Arrays.asList(0, 5, 8)
		);
		carCollection.play(customNumberPicker);
		List<String> statuses = carCollection.getStatuses();
		List<String> expected = Arrays.asList("slow : ", "if : -", "poby : -");

		assertThat(statuses.size()).isEqualTo(expected.size());
		for (int i = 0; i < statuses.size(); i++) {
			assertThat(statuses.get(i)).isEqualTo(expected.get(i));
		}
	}

	@Test
	void 우승자_한명_선정() {
		CarCollection carCollection = new CarCollection(
			Arrays.asList("slow", "if", "poby")
		);
		CustomNumberPicker customNumberPicker = new CustomNumberPicker(
			Arrays.asList(0, 5, 8, 2, 2, 7)
		);
		carCollection.play(customNumberPicker);
		carCollection.play(customNumberPicker);

		List<String> winnerNames = carCollection.getWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(1);

		assertThat(winnerNames.get(0)).isEqualTo("poby");
	}

	@Test
	void 우승자_여러명_선정() {
		CarCollection carCollection = new CarCollection(
			Arrays.asList("slow", "if", "poby","doby")
		);
		CustomNumberPicker customNumberPicker = new CustomNumberPicker(
			Arrays.asList(0,5,8,2, 2,0,7,6, 3,0,2,9)
		);
		carCollection.play(customNumberPicker);
		carCollection.play(customNumberPicker);
		carCollection.play(customNumberPicker);

		List<String> winnerNames = carCollection.getWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(2);

		List<String> expected = Arrays.asList("poby", "doby");
		for (int i = 0; i < winnerNames.size(); i++) {
			assertThat(winnerNames.get(i)).isEqualTo(expected.get(i));
		}
	}
}
