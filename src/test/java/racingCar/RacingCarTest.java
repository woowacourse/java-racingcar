package racingCar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RacingCarTest {
	private final RacingCar racingCar = new RacingCar();

	@Test
	void 자동차_이름_정상_입력() {
		String[] names = racingCar.getCarNames("a,bqwer,cdb");
		assertThat(names).isEqualTo(new String[] {"a", "bqwer", "cdb"});
	}

	@Test
	void 자동차_이름_중복() {
		String[] names = racingCar.getCarNames("a,a,c");
		assertThat(names).isEqualTo(new String[] {"a", "a", "c"});
	}

	@Test
	void 자동차_이름_앞뒤_공백() {
		String[] names = racingCar.getCarNames("   abc, a ,cde  ");
		assertThat(names).isEqualTo(new String[] {"abc", "a", "cde"});
	}

	@Test
	void 자동차_이름_6자_에러() {
		assertThatThrownBy(() -> racingCar.isRightLength("techCourse"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 자동차_이름_공백_에러() {
		assertThatThrownBy(() -> racingCar.isRightLength(""))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 시도_횟수_정상_입력() {
		int times = racingCar.enterTimes("5");
		assertThat(times).isEqualTo(5);
	}

	@Test
	void 시도_횟수_숫자_이외의_값_에러() {
		assertThatThrownBy(() -> racingCar.isRightTimes("!"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 시도_횟수_정수가_아닌_실수값_에러() {
		assertThatThrownBy(() -> racingCar.isRightTimes("1.5"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 시도_횟수_음수_값_에러() {
		assertThatThrownBy(() -> racingCar.isRightTimes("-2"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 자동차_위치_출력_정상() {
		Car car = new Car("woowahan");
		car.moveCar(true);
		assertThat(car.toString()).isEqualTo("woowahan : -");
		car.moveCar(false);
		assertThat(car.toString()).isEqualTo("woowahan : -");
		car.moveCar(true);
		assertThat(car.toString()).isEqualTo("woowahan : --");
	}

	@Test
	void 최종_결과_출력_정상() {
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

		List<Car> result = racingCar.findWinner(cars);
		assertThat(result).isEqualTo(winners);
	}

}
