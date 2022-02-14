package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
	private Car car = new Car("sudal");

	@DisplayName("랜덤 넘버가 4 이상일 경우 전진지시")
	@Test
	void car_hasNext_true() {
		//given
		int randomNumber = 4;
		//when
		boolean stepStatus = car.hasNext(randomNumber);
		//then
		assertTrue(stepStatus);
	}

	@DisplayName("랜덤 넘버가 3 이하일 경우 멈춤")
	@Test
	void car_drive_false() {
		//given
		int randomNumber = 3;
		//when
		boolean stepStatus = car.hasNext(randomNumber);
		//then
		assertFalse(stepStatus);
	}
}