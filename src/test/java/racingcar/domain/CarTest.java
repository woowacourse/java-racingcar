package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import racingcar.service.CarMoveGenerator;
import racingcar.service.MovePolicy;

class CarTest {

	@DisplayName("랜덤 넘버가 4 이상일 경우 전진 요청")
	@Test
	void car_hasNext_true() {
		//given
		Car car = new Car("sudal");
		//when
		boolean actual = new CarMoveGenerator().hasNext(4);
		//then
		assertTrue(actual);
	}

	@DisplayName("랜덤 넘버가 4 이상일 경우 전진")
	@Test
	void car_drive_true() {
		Car car = new Car("sudal");
		//when
		MovePolicy movePolicy = (int random) -> true;
		car.drive(movePolicy);
		//then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("랜덤 넘버가 3 이하일 경우 멈춤 요청")
	@Test
	void car_hasNext_false() {
		//given
		Car car = new Car("sudal");
		//when
		boolean actual = new CarMoveGenerator().hasNext(3);
		//then
		assertFalse(actual);
	}

	@DisplayName("랜덤 넘버가 3 이하일 경우 멈춤")
	@Test
	void car_drive_false() {
		Car car = new Car("sudal");
		//when
		MovePolicy movePolicy = (int random) -> false;
		car.drive(movePolicy);
		//then
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@DisplayName("같은 위치인지 비교 성공")
	@Test
	void isSamePosition_true() {
		Car targetPositionCar = new Car("hee", 1);
		Car otherPositionCar = new Car("bong", 1);
		//when
		boolean actual = targetPositionCar.isSamePosition(otherPositionCar);
		//then
		assertTrue(actual);
	}

	@DisplayName("같은 위치인지 비교 실패")
	@Test
	void isSamePosition_false() {
		Car targetPositionCar = new Car("hee", 25);
		Car otherPositionCar = new Car("bong", 26);
		//when
		boolean actual = targetPositionCar.isSamePosition(otherPositionCar);
		//then
		assertFalse(actual);
	}
}