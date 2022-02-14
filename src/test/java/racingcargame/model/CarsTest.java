package racingcargame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@DisplayName("Cars 객체가 정상적으로 생성되는지 테스트")
	@Test
	void car_objectCreate() {
		List<String> carNames = List.of("토미", "제인", "데이빗");
		Cars cars = new Cars(carNames);

		HashMap<String, Integer> carsPosition = cars.bringCarsPositionSeparatedByName();

		carsPosition.forEach((carName, carPosition) -> {
			assertThat(carNames).contains(carName);
			assertThat(carPosition).isEqualTo(0);
		});
	}
}
