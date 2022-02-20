package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import racingcar.model.movegenerator.MovableGenerator;
import racingcar.model.movegenerator.NonMovableGenerator;

class RacingCarTest {

	@Test
	void testMovableCar() {
		//given
		RacingCar car = new RacingCar("judy", new MovableGenerator());
		//when
		car.decideMove();
		//then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void testNonMovableCar() {
		//given
		RacingCar car = new RacingCar("pobi", new NonMovableGenerator());
		//when
		car.decideMove();
		//then
		assertThat(car.getPosition()).isEqualTo(0);
	}

}