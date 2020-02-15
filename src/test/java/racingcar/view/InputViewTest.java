// package racingcar.view;
//
// import static org.assertj.core.api.Assertions.*;
//
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.MethodSource;
// import org.junit.jupiter.params.provider.ValueSource;
//
// import racingcar.CarRacing;
//
// class InputViewTest {
// 	private static String[] createNullAndEmpty() {
// 		return new String[] {"", null};
// 	}
//
// 	@ParameterizedTest
// 	@MethodSource("createNullAndEmpty")
// 	void validateEmpty(String input) {
// 		assertThatThrownBy(() -> {
// 			InputView.(input);
// 		}).isInstanceOf(IllegalArgumentException.class)
// 			.hasMessage("입력이 없습니다.");
// 	}
// }
//
// class CarRacingTest {
// 	@ParameterizedTest
// 	@ValueSource(ints = {-1, 0})
// 	void validatePositiveNumber(int negativeNumber) {
// 		assertThatThrownBy(() -> {
// 			CarRacing.validatePositiveNumber(negativeNumber);
// 		}).isInstanceOf(IllegalArgumentException.class)
// 			.hasMessage("2이상의 수를 입력해야합니다.");
// 	}
// }