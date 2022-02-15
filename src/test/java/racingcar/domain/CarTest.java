package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import racingcar.service.StepPolicy;

class CarTest {
	@DisplayName("랜덤 넘버가 4 이상일 경우 전진")
	@Test
	void car_hasNext_true() {
		//given
		Car car = new Car("sudal");
		StepPolicy stepPolicy = () -> true;
		//when
		car.drive(stepPolicy);
		//then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("랜덤 넘버가 3 이하일 경우 멈춤")
	@Test
	void car_drive_false() {
		Car car = new Car("sudal");
		StepPolicy stepPolicy = () -> false;
		//when
		car.drive(stepPolicy);
		//then
		assertThat(car.getPosition()).isEqualTo(0);
	}
}