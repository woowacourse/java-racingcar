package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;
import racing.domain.Cars;

public class CarsTest {

	@Test
	public void winnerTest() {
		Cars cars = new Cars(Arrays.asList(
				new Car("자동차1", 10),
				new Car("자동차2", 3),
				new Car("자동차3", 10)
		));

		List<String> winners = cars.findWinner();
		String winnersName = String.join(",", winners);

		assertThat(winnersName).contains("자동차1");
		assertThat(winnersName).contains("자동차3");
		assertThat(winnersName).doesNotContain("자동차2");
	}
}
