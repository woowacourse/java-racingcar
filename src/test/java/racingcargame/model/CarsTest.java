package racingcargame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@DisplayName("Cars 객체가 정상적으로 생성되는지 테스트")
	@Test
	void createObject_Cars() {
		List<String> carNames = List.of("토미", "제인", "데이빗");
		Cars cars = new Cars(carNames);

		HashMap<String, Integer> carsPosition = cars.bringCarsPositionSeparatedByName();

		carsPosition.forEach((carName, carPosition) -> {
			assertThat(carNames).contains(carName);
			assertThat(carPosition).isEqualTo(0);
		});
	}

	@DisplayName("우승자가 정상적으로 선정되는지 테스트")
	@Test
	void findWinner() {
		List<String> carNames = List.of("토미", "제인", "데이빗");
		Cars cars = new Cars(carNames, 4);

		assertThat(cars.findWinner()).isEqualTo(List.of("토미", "제인", "데이빗"));
	}
}
