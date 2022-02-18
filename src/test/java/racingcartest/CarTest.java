package racingcartest;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

	@Test
	public void carMoveTest() {
		Car car = new Car("pobi");
		car.movePosition(5);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	public void carPositionEqualTest() {
		Car car = new Car("pobi");
		car.movePosition(5);
		car.movePosition(6);
		assertThat(car.isPositionAt(2)).isEqualTo(true);
	}
}
