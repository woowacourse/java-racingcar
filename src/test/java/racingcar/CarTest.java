package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
	private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 5글자를 초과할 수 없습니다.";
	private static final String EMPTY_NAME_ERROR = "[ERROR] 이름은 공백일 수 없습니다.";

	@Test
	public void 이름_4글자_일때_차_생성() {
		String name = "four";
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	public void 이름_5글자_일때_차_생성() {
		String name = "forky";
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	public void 이름_6글자_일때_차_생성() {
		assertThatThrownBy(() -> new Car("abcdef"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(NAME_LENGTH_ERROR);
	}

	@Test
	public void 차_1대_생성() {
		List<Car> cars = CarFactory.of("kun");
		assertThat(cars.size()).isEqualTo(1);
	}

	@Test
	public void 차_여러대_생성() {
		String names = "forky,kun";
		List<Car> cars = CarFactory.of(names);
		assertThat(cars.size()).isEqualTo(2);
	}

	@Test
	public void 공백_이름() {
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(EMPTY_NAME_ERROR);
	}

	@Test
	public void toString_kun() {
		Car car = new Car("kun");
		assertThat(car.toString()).startsWith("kun : ");
	}

	@Test
	public void toString_forky() {
		Car car = new Car("forky");
		assertThat(car.toString()).startsWith("forky : ");
	}

	@Test
	public void toString_position_1() {
		Car car = new Car("kun");
		car.move(true);
		assertThat(car.toString()).isEqualTo("kun : -");
	}

	@Test
	public void toString_position_3() {
		Car car = new Car("kun");
		for (int i = 0; i < 3 ; i++) {
			car.move(true);
		}
		assertThat(car.toString()).isEqualTo("kun : ---");
	}
}
