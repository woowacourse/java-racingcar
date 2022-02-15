package racingcar.models;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.utils.RandomNumber;

@DisplayName("Car 클래스를 테스트한다.")
class CarTest {

	RandomNumber randomNumber = mock(RandomNumber.class);

	@Test
	@DisplayName("자동차가 앞으로 전진하는지 확인한다")
	void goForward() {
		when(randomNumber.getRandomNumber()).thenReturn(6);
		Car car = new Car(randomNumber, "a");
		int exPosition = car.getPosition();

		car.goForward();

		assertThat(exPosition + 1).isEqualTo(car.getPosition());
	}

	@Test
	@DisplayName("자동차가 앞으로 전진하지 않는지 확인한다")
	void dontGoForward() {
		when(randomNumber.getRandomNumber()).thenReturn(2);
		Car car = new Car(randomNumber, "a");
		int exPosition = car.getPosition();

		car.goForward();

		assertThat(exPosition).isEqualTo(car.getPosition());
	}
}