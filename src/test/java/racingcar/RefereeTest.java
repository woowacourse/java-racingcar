package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RefereeTest {
	@Test
	public void 차_전진_판단() {
		Car car = new Car("kun");
		Referee.moveCar(car, 5);
		assertThat(car.getPosition()).isEqualTo(1);
	}
}
