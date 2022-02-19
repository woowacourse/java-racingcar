package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

	@DisplayName("자동차 이름 공백 테스트")
	@Test
	void car_name_empty() {
		assertThatThrownBy(() -> {
			Car car = new Car(" ");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이름 null 테스트")
	@Test
	void car_name_null() {
		assertThatThrownBy(() -> {
			Car car = new Car(null);
		}).isInstanceOf(NullPointerException.class);
	}

	@DisplayName("자동차 이름 길이 테스트")
	@Test
	void car_name_length() {
		assertThatThrownBy(() -> {
			Car car = new Car("yukong");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 위치 음수 테스트")
	@Test
	void car_position_negative() {
		assertThatThrownBy(() -> {
			Car car = new Car("name", -1);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("랜덤 넘버가 4 이상일 경우 전진")
	@Test
	void car_drive_true() {
		Car carPositionZero = new Car("zero"); // position: 0
		Car carDriveTrue = new Car("drive");

		Movable movable = () -> 4;

		carDriveTrue.drive(movable);

		assertFalse(carDriveTrue.isSamePosition(carPositionZero));
	}

	@DisplayName("랜덤 넘버가 3 이하일 경우 멈춤")
	@Test
	void car_drive_false() {
		Car carPositionZero = new Car("zero"); // position: 0
		Car carDriveFalse = new Car("drive");

		Movable movable = () -> 3;

		carDriveFalse.drive(movable);

		assertTrue(carDriveFalse.isSamePosition(carPositionZero));
	}
}