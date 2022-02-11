package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
	Car car = new Car("sudal");

	@DisplayName("랜덤 넘버가 4 이상일 경우 전진")
	@Test
	void car_drive_true() {
		//given
		int positionStatus = car.getPosition();
		boolean directing = true;
		//when
		car.drive(directing);
		//then
		assertThat(car.getPosition()).isEqualTo(positionStatus + 1);
	}

	@DisplayName("랜덤 넘버가 3 이하일 경우 멈춤")
	@Test
	void car_drive_false() {
		//given
		int positionStatus = car.getPosition();
		boolean directing = false;
		//when
		car.drive(directing);
		//then
		assertThat(car.getPosition()).isEqualTo(positionStatus);
	}
}