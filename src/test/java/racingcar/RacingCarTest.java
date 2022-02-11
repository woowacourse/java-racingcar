package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.controller.RacingCarController;
import racingcar.domain.Car;
import racingcar.domain.ParticipateCars;
import racingcar.domain.WinnerNames;
import racingcar.util.BoundedRandomNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
public class RacingCarTest {
	public RacingCarController racingCarController = new RacingCarController();
	public BoundedRandomNumberGenerator randomNumberGenerator = new BoundedRandomNumberGenerator(9, 0);
	public ParticipateCars participateCars = new ParticipateCars();
	public WinnerNames winnerNames = new WinnerNames();

	@Test
	public void 자동차_이름_분리해서_가져오기_테스트() {
		List<String> carNames = racingCarController.getCarNames("이브,클레이,포비");
		assertThat(carNames.get(0)).isEqualTo("이브");
		assertThat(carNames.get(1)).isEqualTo("클레이");
		assertThat(carNames.get(2)).isEqualTo("포비");
	}

	@Test
	public void 빈_문자열_입력_테스트() {
		assertThatThrownBy(() -> racingCarController.getCarNames(""))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
	}

	@Test
	public void 자동차_이름_글자수_테스트() {
		assertThatThrownBy(() -> racingCarController.getCarNames("이브,클레이클레이,포비"))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
	}

	@Test
	public void 자동차_이름이_존재하지_않는_경우_테스트() {
		assertThatThrownBy(() -> racingCarController.getCarNames("이브,,포비"))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("모든 자동차 이름은 반드시 존재해야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"이브, ,포비", "이브,   ,포비"})
	public void 자동차_이름이_공백인_경우_테스트(String carNamesLine) {
		assertThatThrownBy(() -> racingCarController.getCarNames(carNamesLine))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("자동차 이름은 공백으로 설정할 수 없습니다.");
	}

	@Test
	public void 자동차_이름_중복_테스트() {
		assertThatThrownBy(() -> racingCarController.getCarNames("이브,이브,포비"))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
	}

	@Test
	public void 시도_횟수_입력_테스트() {
		int gameCount = racingCarController.getTrialCount("3");
		assertThat(gameCount).isEqualTo(3);
	}

	@Test
	public void 숫자가_아닌_시도_횟수_테스트() {
		assertThatThrownBy(() -> racingCarController.getTrialCount("이브"))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("시도 횟수가 숫자가 아닙니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0"})
	public void 시도_횟수_음수_혹은_0_테스트(String trial) {
		assertThatThrownBy(() -> racingCarController.getTrialCount(trial))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("시도 횟수가 음수나 0이 될 수 없습니다.");
	}

	@Test
	public void 랜덤값_범위_테스트() {
		int number = randomNumberGenerator.generate();
		assertThat(0 <= number && number <= 9).isEqualTo(true);
	}

	@Test
	public void 자동차_멈춤_테스트() {
		Car car = new Car("클레이", new BoundedRandomNumberGenerator(3, 0));
		assertThat(car.isMovable()).isEqualTo(false);
	}

	@Test
	public void 자동차_전진_테스트() {
		Car car = new Car("클레이", new BoundedRandomNumberGenerator(9, 4));
		assertThat(car.isMovable()).isEqualTo(true);
	}

	@Test
	public void 자동차_생성_테스트() {
		List<String> carNames = racingCarController.getCarNames("이브,클레이,포비");
		participateCars.generateCars(carNames);
		assertThat(participateCars.getSize()).isEqualTo(3);
	}

	@Test
	public void 최종_우승자_찾기_테스트() {
		participateCars.addCar(new Car("이브", new BoundedRandomNumberGenerator(9, 4)));
		participateCars.addCar(new Car("클레이", new BoundedRandomNumberGenerator(3, 0)));
		participateCars.addCar(new Car("포비", new BoundedRandomNumberGenerator(9, 4)));
		participateCars.executeCarRacing();
		List<String> winners = participateCars.findWinners().getWinnerNames();

		assertThat(winners.size()).isEqualTo(2);
		assertThat(winners).contains("이브", "포비");
	}
}
