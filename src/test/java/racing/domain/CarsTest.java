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
	public void randomGenerateTest() {
		Cars cars = new Cars(Arrays.asList("1","2"));
		assertThat(cars.randomGenerate()).isBetween(0, 9);
	}

	@Test
	public void winnerTest() {
		Cars cars = new Cars(Arrays.asList("자동차1", "자동차2", "자동차3"));
		cars.getCars().get(1).goForward(5);
		List<String> winners = cars.findWinner();
		String winnersName = String.join(",", winners);

		assertThat(winnersName).contains("자동차2");
		assertThat(winnersName).doesNotContain("자동차1");
	}
}
