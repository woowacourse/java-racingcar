package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.util.CarFactory;

public class CarTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	@DisplayName("CarFactory 통한 차 여러대 생성")
	public void generate_cars_through_carFactory() {
		assertThat(CarFactory.of("forky,kun"))
			.containsExactlyInAnyOrder(new Car("forky"), new Car("kun"));
	}

	@Test
	@DisplayName("이름이 5글자를 넘을 때 Exception 발생")
	public void name_longer_then_5_exception() {
		assertThatThrownBy(() -> new Car("abcdef"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	@DisplayName("이름이 공백일 때 Exception 발생")
	public void name_blank_exception() {
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}
}
