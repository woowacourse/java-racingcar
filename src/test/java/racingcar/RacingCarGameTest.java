package racingcar;

import static java.nio.charset.StandardCharsets.*;
import static org.assertj.core.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.Cars;
import racingcar.domain.GameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class RacingCarGameTest {

	Cars cars;
	OutputView outputView;
	InputView inputView;
	GameManager gameManager = new GameManager(inputView, outputView, cars);

	InputStream inputStream;
	PrintStream outputStream;

	@AfterEach
	void close() throws Exception {
		inputStream.close();
		outputStream.close();
	}

	@DisplayName("자동차 경주 통합 정상 작동 테스트")
	@Test
	void playGameTest() {
		String carNames = "헤나, 썬샷, 루카\n5";
		inputStream = new ByteArrayInputStream(carNames.getBytes(UTF_8));
		OutputStream out = new ByteArrayOutputStream();
		outputStream = new PrintStream(out);

		System.setIn(inputStream);
		System.setOut(outputStream);

		cars = new Cars();
		outputView = new OutputView();
		inputView = new InputView();
		gameManager = new GameManager(inputView, outputView, cars);
		GameManager gameManager = new GameManager(inputView, outputView, cars);
		gameManager.playGame();

		assertThat(out.toString()).contains("최종 우승했습니다.");
	}

	@DisplayName("자동차 경주 통합 예외 처리 후 정상 작동 테스트")
	@ParameterizedTest
	@MethodSource("playGameExceptionDummy")
	void playGameExceptionTest(String playGameExceptionInput) {
		inputStream = new ByteArrayInputStream(playGameExceptionInput.getBytes(UTF_8));
		OutputStream out = new ByteArrayOutputStream();
		outputStream = new PrintStream(out);

		System.setIn(inputStream);
		System.setOut(outputStream);

		cars = new Cars();
		outputView = new OutputView();
		inputView = new InputView();
		gameManager = new GameManager(inputView, outputView, cars);
		GameManager gameManager = new GameManager(inputView, outputView, cars);

		gameManager.playGame();
		String gameTotalMessage = out.toString();

		assertThat(gameTotalMessage).contains("[ERROR]",  "최종 우승했습니다.");
	}

	static Stream<Arguments> playGameExceptionDummy() {
		return Stream.of(
			Arguments.arguments("헤나, 썬샷, 헤나\n헤나, 썬샷\n5"),
			Arguments.arguments("헤나, 썬샷, 우아한테크코스\n헤나, 썬샷\n5"),
			Arguments.arguments("헤나\n헤나, 썬샷\n5"),
			Arguments.arguments("헤나, 썬샷, 헤나\n헤나, 썬샷\n0\n5"),
			Arguments.arguments("헤나, 썬샷, 헤나\n헤나, 썬샷\n다섯번\n5")
		);
	}
}