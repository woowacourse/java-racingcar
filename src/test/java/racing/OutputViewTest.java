package racing;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racing.domain.Car;
import racing.view.OutputView;

public class OutputViewTest {
	@ParameterizedTest
	@MethodSource("generateWinner")
	public void printWinnerTest(List<Car> winners, String expected) {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		OutputView.printWinner(winners);

		assertThat(outContent.toString()).isEqualTo(expected);
	}

	static Stream<Arguments> generateWinner() {
		return Stream.of(
			Arguments.of(Arrays.asList(new Car("자동차1")), "자동차1 최종 우승했습니다."),
			Arguments.of(Arrays.asList(new Car("자동차1"), new Car("자동차2")), "자동차1,자동차2 최종 우승했습니다.")
		);
	}
}
