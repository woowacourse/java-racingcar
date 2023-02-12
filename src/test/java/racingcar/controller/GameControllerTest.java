package racingcar.controller;

import static java.nio.charset.StandardCharsets.*;
import static org.assertj.core.api.Assertions.*;
import static racingcar.dummy.TestDataDummy.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.game.Cars;
import racingcar.domain.game.GameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

@DisplayName("게임 컨트롤러")
class GameControllerTest {
	GameController gameController;
	GameManager gameManager;
	Cars cars;
	OutputView outputView;
	InputView inputView;
	InputStream inputStream;
	OutputStream outputStream;
	PrintStream printStream;

	@BeforeEach
	void setUp() {
		cars = new Cars();
	}

	@AfterEach
	void close() throws Exception {
		inputStream.close();
		printStream.close();
		outputStream.close();
	}

	@DisplayName("자동차 경주 통합 정상 작동 성공 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("playGameDummy")
	void playGameSuccessTest(String carNames) {
		inputStream = new ByteArrayInputStream(carNames.getBytes(UTF_8));
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);

		System.setIn(inputStream);
		System.setOut(printStream);

		cars = new Cars();
		outputView = new OutputView();
		inputView = new InputView();
		gameManager = new GameManager(CAR_MOVEMENT_FORWARD, cars);
		gameController = new GameController(inputView, outputView, gameManager);

		gameController.playGame();

		assertThat(outputStream.toString()).contains("최종 우승했습니다.");
	}

	@DisplayName("자동차 경주 통합 예외 처리 후 정상 작동 성공 테스트")
	@ParameterizedTest(name = "inputWithException = {0}")
	@MethodSource("playGameExceptionDummy")
	void playGameExceptionTest(String inputWithException) {
		inputStream = new ByteArrayInputStream(inputWithException.getBytes(UTF_8));
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);

		System.setIn(inputStream);
		System.setOut(printStream);

		cars = new Cars();
		outputView = new OutputView();
		inputView = new InputView();
		gameManager = new GameManager(CAR_MOVEMENT_FORWARD, cars);
		gameController = new GameController(inputView, outputView, gameManager);

		gameController.playGame();
		String gameTotalMessage = outputStream.toString();

		assertThat(gameTotalMessage).contains("[ERROR]", "최종 우승했습니다.");
	}

	static Stream<Arguments> playGameDummy() {
		return Stream.of(
			Arguments.arguments("헤나, 썬샷, 루카" + System.lineSeparator() + "5"),
			Arguments.arguments("헤나, 썬샷" + System.lineSeparator() + "5"),
			Arguments.arguments("썬샷, 루카" + System.lineSeparator() + "5"),
			Arguments.arguments("루카, 헤나" + System.lineSeparator() + "5")
		);
	}

	static Stream<Arguments> playGameExceptionDummy() {
		return Stream.of(
			Arguments.arguments(
				"헤나, 썬샷, 헤나" + System.lineSeparator()
					+ "헤나, 썬샷" + System.lineSeparator()
					+ "5"
			),
			Arguments.arguments(
				"헤나, 썬샷, 우아한테크코스" + System.lineSeparator()
					+ "헤나, 썬샷" + System.lineSeparator()
					+ "5"),
			Arguments.arguments(
				"헤나" + System.lineSeparator()
					+ "헤나, 썬샷" + System.lineSeparator()
					+ "5"),
			Arguments.arguments(
				"헤나, 썬샷, 헤나" + System.lineSeparator()
					+ "헤나, 썬샷" + System.lineSeparator()
					+ "0" + System.lineSeparator()
					+ "5"),
			Arguments.arguments(
				"헤나, 썬샷, 헤나" + System.lineSeparator()
					+ "헤나, 썬샷" + System.lineSeparator()
					+ "다섯번" + System.lineSeparator()
					+ "5")
		);
	}
}