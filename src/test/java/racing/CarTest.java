package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	public void carInitTest() {
		List<String> input = Arrays.asList("A", "B", "C");
		Cars cars = new Cars(input);
		assertThat(cars.size()).isEqualTo(input.size());
		assertThat(cars.getAllNames()).isEqualTo(input);
	}
}
