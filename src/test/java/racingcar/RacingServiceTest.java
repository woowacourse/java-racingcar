package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.repository.CarRepository;
import racingcar.service.RacingService;
import racingcar.util.Converter;

public class RacingServiceTest {

	@Test
	public void 자동차_저장() {
		String input = "pobi,joon";

		RacingService racingService = new RacingService();
		racingService.registerCars(Converter.toCarList(input));

		CarRepository carRepository = new CarRepository();
		int carCount = carRepository.count();

		assertThat(carCount).isEqualTo(2);
	}
}
