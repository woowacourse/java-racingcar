package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import racing.domain.Car;
import racing.domain.Cars;

public class CarsTest {
	@Test
	public void winnerTest() {
		Cars cars = new Cars(Arrays.asList("자동차1", "자동차2", "자동차3"));
		cars.getCars().get(1).goForward(5);
		List<Car> winners = cars.findWinner();
		String winnersName = winners.stream().map(Car::getName).collect(Collectors.joining(","));
		assertThat(winnersName).contains("자동차2");
		assertThat(winnersName).doesNotContain("자동차1");
	}
}
