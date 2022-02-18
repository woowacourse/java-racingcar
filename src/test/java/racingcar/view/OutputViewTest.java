package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.MovingPolicy;

public class OutputViewTest {

	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	@DisplayName("자동차의 포지션을 형식에 맞게 출력한다.")
	void printStatus_포지션() {
		final MovingPolicy movingPolicy = () -> true;

		final List<Car> cars = Arrays.asList(
			new Car("메트"),
			new Car("잉")
		);

		cars.forEach(car -> car.move(movingPolicy));
		OutPutView.printStatus(cars);
		assertThat(outputStream.toString()).isEqualTo("메트 : -\n잉 : -\n\n");
	}

	@Test
	@DisplayName("우승자를 형식에 맞게 출력한다.")
	void printResult_우승자() {
		List<String> winners = Arrays.asList("메트", "잉");
		OutPutView.printResult(winners);
		assertThat(outputStream.toString()).isEqualTo("메트, 잉가 최종 우승했습니다.\n");
	}
}
