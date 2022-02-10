package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
public class RacingCarTest {
	public InputManager inputManager = new InputManager();
	public InputValidator inputValidator = new InputValidator();
	public RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(9, 0);

	@Test
	public void 자동차_이름_분리해서_가져오기_테스트() {
		List<String> carNames = inputManager.splitAndSaveCarNames("이브,클레이,포비");
		assertThat(carNames.get(0)).isEqualTo("이브");
		assertThat(carNames.get(1)).isEqualTo("클레이");
		assertThat(carNames.get(2)).isEqualTo("포비");
	}

	@Test
	public void 빈_문자열_입력_테스트() {
		assertThatThrownBy(() -> { inputManager.splitAndSaveCarNames("");})
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
	}

	@Test
	public void 자동차_이름_글자수_테스트() {
		List<String> carNames = inputManager.splitAndSaveCarNames("이브,클레이클레이,포비");

		assertThatThrownBy(() -> { inputValidator.checkCarNameLength(carNames); })
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
	}

	@Test
	public void 자동차_이름이_존재하지_않는_경우_테스트() {
		List<String> carNames = inputManager.splitAndSaveCarNames("이브,,포비");

		assertThatThrownBy(() -> { inputValidator.validateIsSpace(carNames); })
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("모든 자동차 이름은 반드시 존재해야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"이브, ,포비", "이브,       ,포비"})
	public void 자동차_이름이_공백인_경우_테스트(String carNamesLine) {
		List<String> carNames = inputManager.splitAndSaveCarNames(carNamesLine);

		assertThatThrownBy(() -> { inputValidator.validateIsSpace(carNames); })
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("자동차 이름은 공백으로 설정할 수 없습니다.");
	}

	@Test
	public void 자동차_이름_중복_테스트() {
		List<String> carNames = inputManager.splitAndSaveCarNames("이브,이브,포비");

		assertThatThrownBy(() -> { inputValidator.validateDuplication(carNames); })
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
	}

	@Test
	public void 시도_횟수_입력_테스트() {
		int gameCount = inputManager.getTrial("3");
		assertThat(gameCount).isEqualTo(3);
	}

	@Test
	public void 숫자가_아닌_시도_횟수_테스트() {
		assertThatThrownBy(() -> { inputManager.getTrial("이브"); })
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("시도 횟수가 숫자가 아닙니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0"})
	public void 시도_횟수_음수_혹은_0_테스트(String trial) {
		assertThatThrownBy(() -> { inputManager.getTrial(trial); })
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("시도 횟수가 음수나 0이 될 수 없습니다.");
	}

	@Test
	public void 랜덤값_범위_테스트() {
		int number = randomNumberGenerator.generate();
		assertThat(0<= number && number <= 9).isEqualTo(true);
	}

	@Test
	public void 자동차_멈춤_테스트() {
		Car car = new Car("클레이", new RandomNumberGenerator(3, 0));
		assertThat(car.isMove()).isEqualTo(false);
	}

	@Test
	public void 자동차_전진_테스트() {
		Car car = new Car("클레이", new RandomNumberGenerator(9, 4));
		assertThat(car.isMove()).isEqualTo(true);
	}
}
