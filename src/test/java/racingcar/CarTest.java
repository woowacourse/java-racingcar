package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	public void 차_생성() {
		String name = "forky";
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	public void 차_여러대_생성() {
		String names = "forky,kun";
		List<Car> cars = CarFactory.of(names);
		assertThat(cars.size()).isEqualTo(2);
	}

	@Test
	public void 이름_5글자_이상() {
		assertThatThrownBy(() -> new Car("abcdef"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith("[ERROR]");
	}
}
