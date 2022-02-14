package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.car.Car;

public class FormatTest {
	@DisplayName("차의 이름과 위치를 현황판에 맞게 포맷")
	@Test
	void carResult() {
		Car car = Car.of("car1", 3);
		Assertions.assertThat(Format.carResult(car)).isEqualTo("car1 : ---");
	}
}
