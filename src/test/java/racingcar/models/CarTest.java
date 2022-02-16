package racingcar.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Car 클래스를 테스트한다.")
class CarTest {

	@Test
	@DisplayName("자동차가 앞으로 전진하는지 확인한다")
	void goForward() {
		Car car = new Car("a");
		int exPosition = car.getPosition();

		car.goForward(4);

		assertThat(exPosition + 1).isEqualTo(car.getPosition());
	}

	@Test
	@DisplayName("자동차가 앞으로 전진하지 않는지 확인한다")
	void dontGoForward() {
		Car car = new Car("a");
		int exPosition = car.getPosition();

		car.goForward(3);

		assertThat(exPosition).isEqualTo(car.getPosition());
	}
}