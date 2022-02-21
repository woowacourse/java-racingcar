package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.service.MovingCondition;

public class CarTest {

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {" ", "   ", "\t", "\n"})
	public void Car_생성자_테스트(String name) {
		MovingCondition movingCondition = () -> true;
		assertThatThrownBy(() -> new Car(name, 0, movingCondition)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 전진_테스트() {
		MovingCondition movingCondition = () -> true;
		Car car = new Car("아스피", 0, movingCondition);
		car.move();
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	public void 같은_위치_자동차_테스트() {
		MovingCondition movingCondition1 = () -> true;
		MovingCondition movingCondition2 = () -> true;
		Car azpi = new Car("아스피", 0, movingCondition1);
		Car baekara = new Car("배카라", 0, movingCondition2);
		assertThat(azpi.isSamePosition(baekara)).isEqualTo(true);
	}

	@Test
	public void 다른_위치_자동차_테스트() {
		MovingCondition movingCondition1 = () -> true;
		MovingCondition movingCondition2 = () -> true;
		Car azpi = new Car("아스피", 0, movingCondition1);
		Car baekara = new Car("배카라", 1, movingCondition2);
		assertThat(azpi.isSamePosition(baekara)).isEqualTo(false);
	}

}
