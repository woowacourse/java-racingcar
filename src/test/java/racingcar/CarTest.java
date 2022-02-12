package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class CarTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	public void 차_생성() {
		String name = "forky";
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	public void 차_여러대_생성() {
		String names = "forky,kun";
		Set<Car> cars = CarFactory.of(names);
		assertThat(cars.stream().anyMatch(car -> car.getName().equals("kun"))).isTrue();
	}

	@Test
	public void 이름_5글자_제한_오류발생() {
		assertThatThrownBy(() -> new Car("abcdef"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	public void 공백_이름() {
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	public void 중복된_이름() {
		assertThatThrownBy(() -> CarFactory.of("forky,forky"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}
}
