package racingcar.models;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스를 테스트한다.")
class CarTest {

	@Test
	@DisplayName("자동차가 앞으로 전진하는지 확인한다")
	void goForward() {
		CarMockGoForward car = new CarMockGoForward("a");
		int exPosition = car.getPosition();

		car.startThisTurn();

		assertThat(exPosition + 1).isEqualTo(car.getPosition());
	}

	@Test
	@DisplayName("자동차가 앞으로 전진하지 않는지 확인한다")
	void dontGoForward() {
		CarMockDontGoForward car = new CarMockDontGoForward("a");
		int exPosition = car.getPosition();

		car.startThisTurn();

		assertThat(exPosition).isEqualTo(car.getPosition());
	}
}