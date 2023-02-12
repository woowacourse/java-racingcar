package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.GameManager;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.*;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
	NumberGenerator numberGenerator;
	OutputView outputView;
	InputView inputView;
	GameManager gameManager;

	InputStream inputStream;
	PrintStream outputStream;
	OutputStream out;

	@AfterEach
	void close() throws Exception {
		inputStream.close();
		outputStream.close();
	}

	@DisplayName("자동차 경주 통합 정상 작동 테스트")
	@Test
	void playGameTest() {
		String carNames = "헤나, 썬샷, 루카"+System.lineSeparator()+"5";
		inputStream = new ByteArrayInputStream(carNames.getBytes(UTF_8));
		out = new ByteArrayOutputStream();
		outputStream = new PrintStream(out);

		System.setIn(inputStream);
		System.setOut(outputStream);

		numberGenerator = new RandomNumberGenerator();
		outputView = new OutputView();
		inputView = new InputView();
		gameManager = new GameManager(inputView, outputView, numberGenerator);

		gameManager.playGame();

		assertThat(out.toString()).contains("최종 우승했습니다.");
	}

	@DisplayName("자동차 경주 통합 예외 처리 후 정상 작동 테스트")
	@ParameterizedTest
	@MethodSource("playGameExceptionDummy")
	void playGameExceptionTest(String playGameExceptionInput) {
		inputStream = new ByteArrayInputStream(playGameExceptionInput.getBytes(UTF_8));
		out = new ByteArrayOutputStream();
		outputStream = new PrintStream(out);

		System.setIn(inputStream);
		System.setOut(outputStream);

		numberGenerator = new RandomNumberGenerator();
		outputView = new OutputView();
		inputView = new InputView();
		gameManager = new GameManager(inputView, outputView, numberGenerator);

		gameManager.playGame();
		String gameTotalMessage = out.toString();

		assertThat(gameTotalMessage).contains("[ERROR]",  "최종 우승했습니다.");
	}

	static Stream<Arguments> playGameExceptionDummy() {
		return Stream.of(
			Arguments.arguments("헤나, 썬샷, 헤나"+System.lineSeparator()
					+"헤나, 썬샷"+System.lineSeparator()
					+"5"),
			Arguments.arguments("헤나, 썬샷, 우아한테크코스"+System.lineSeparator()
					+"헤나, 썬샷"+System.lineSeparator()
					+"5"),
			Arguments.arguments("헤나"+System.lineSeparator()
					+"헤나, 썬샷" +System.lineSeparator()
					+"5"),
			Arguments.arguments("헤나, 썬샷, 헤나"+System.lineSeparator()
					+"헤나, 썬샷"+System.lineSeparator()
					+"0"+System.lineSeparator()
					+"5"),
			Arguments.arguments("헤나, 썬샷, 헤나"+System.lineSeparator()
					+"헤나, 썬샷"+System.lineSeparator()
					+"다섯번"+System.lineSeparator()
					+"5")
		);
	}
}
