package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.utils.RandomIntegerGenerator;

public class CarTest {
	private static final int PROCEED_FlAG_NUMBER = 4;

	@Test
	void 전진_여부() {
		Car car = new Car("Car1");
		car.proceed(PROCEED_FlAG_NUMBER);
		assertThat(car.getPosition()).isEqualTo(1);
	}
}
