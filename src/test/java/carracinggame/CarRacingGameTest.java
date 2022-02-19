package carracinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarRacingGameTest {
	private final CarRacingGame carRacingGame = new CarRacingGame();

	@DisplayName("자동차 이름 정상 입력")
	@Test
	void 자동차_이름_정상_입력() {
		String[] names = carRacingGame.makeCarNames("a,bqwer,cdb");
		assertThat(names).isEqualTo(new String[] {"a", "bqwer", "cdb"});
	}

	@DisplayName("자동차 이름 중복 확인")
	@Test
	void 자동차_이름_중복() {
		String[] names = carRacingGame.makeCarNames("a,a,c");
		assertThat(names).isEqualTo(new String[] {"a", "a", "c"});
	}

	@DisplayName("자동차 이름 입력 앞뒤 공백 에러 확인")
	@Test
	void 자동차_이름_앞뒤_공백_에러_확인() {
		assertThatThrownBy(() -> carRacingGame.checkBlank("a,b,"))
				.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("자동차 이름 앞뒤 공백 제거 확인")
	@Test
	void 자동차_이름_앞뒤_공백() {
		String[] names = carRacingGame.makeCarNames("   abc, a ,cde  ");
		assertThat(names).isEqualTo(new String[] {"abc", "a", "cde"});
	}

	@DisplayName("자동차 이름이 6자 이상일 때 에러 확인")
	@Test
	void 자동차_이름_6자_에러() {
		assertThatThrownBy(() -> carRacingGame.checkRightLength("techCourse"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("자동차 이름이 공백일 때 에러 확인")
	@Test
	void 자동차_이름_공백_에러() {
		assertThatThrownBy(() -> carRacingGame.checkRightLength(""))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("자동차 이름이 null 일 때 에러 확인")
	@Test
	void 자동차_이름_NULL_에러() {
		assertThatThrownBy(() -> carRacingGame.checkRightLength(null))
				.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("경기 횟수가 올바르지 않을 값일 때 에러 확인")
	@ParameterizedTest
	@ValueSource(strings = {"-2", "a", "-1", "1.5"})
	void testInvalidTimes(String times) {
		assertThatThrownBy(() -> carRacingGame.isRightTimes(times))
				.isInstanceOf(RuntimeException.class);

	}

	@DisplayName("경기 횟수가 숫자 이외의 값일 때 에러 확인")
	@Test
	void 시도_횟수_숫자_이외의_값_에러() {
		assertThatThrownBy(() -> carRacingGame.isRightTimes("!"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("시도 횟수가 실수일 떄 에러 확인")
	@Test
	void 시도_횟수_정수가_아닌_실수값_에러() {
		assertThatThrownBy(() -> carRacingGame.isRightTimes("1.5"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("시도 횟수가 음수일 떄 에러 확인")
	@Test
	void 시도_횟수_음수_값_에러() {
		assertThatThrownBy(() -> carRacingGame.isRightTimes("-2"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("자동차 경주 우승자 선정 결과 테스트")
	@Test
	void 자동차경주_우승자_선정_결과() {
		List<Car> cars = new ArrayList<>();
		List<Car> winners = new ArrayList<>();

		Car car1 = new Car("a");
		Car car2 = new Car("b");
		Car car3 = new Car("c");

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		cars.get(0).moveCar(true);
		cars.get(0).moveCar(true);
		cars.get(1).moveCar(true);
		cars.get(1).moveCar(true);
		cars.get(2).moveCar(false);

		winners.add(car1);
		winners.add(car2);

		List<Car> result = carRacingGame.findWinner(cars);
		assertThat(result).isEqualTo(winners);
	}

}
