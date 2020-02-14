package racing.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
	@Test
	public void printEachPositionTest() {
		String expected = "자동차1 : -\r\n";
		Car car = new Car("자동차1");
		car.goForward(6);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		OutputView.printEachPosition(car);

		assertThat(outContent.toString()).isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("generateWinner")
	public void printWinnerTest(List<String> winners, String expected) {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		OutputView.printWinner(winners);

		assertThat(outContent.toString()).contains(expected);
	}

	static Stream<Arguments> generateWinner() {
		return Stream.of(
			Arguments.of(Arrays.asList("자동차1"), "자동차1 최종 우승했습니다."),
			Arguments.of(Arrays.asList("자동차1", "자동차2"), "자동차1,자동차2 최종 우승했습니다.")
		);
	}
}
