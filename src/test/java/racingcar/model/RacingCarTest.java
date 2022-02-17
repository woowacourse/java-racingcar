package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static racingcar.utlis.RandomNumberGenerator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

	@DisplayName("judy일 때")
	@Test
	void testCustomDecideMoveCar() {
		//given
		RacingCar car = new RacingCar("judy", 0);
		//when
		car.decideMove(getRandomInt());
		//then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("pobi일 때")
	@Test
	void testCustomDecideMoveCar_2() {
		//given
		RacingCar car = new RacingCar("pobi", 0);
		//when
		car.decideMove(getRandomInt());
		//then
		assertThat(car.getPosition()).isEqualTo(0);
	}

}