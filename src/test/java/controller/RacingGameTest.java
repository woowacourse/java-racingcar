package controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.strategy.MovingStrategy;
import view.InputView;
import view.OutputView;

class RacingGameTest {
	private PrintStream standardOut;
	private OutputStream captor;

	@BeforeEach
	void setUp() {
		standardOut = System.out;
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
		System.out.println(captor.toString().trim());
	}

	@DisplayName("게임 정상 진행 확인")
	@Test
	void run() {
		command("a,b", "3");
		start();

		assertThat(captor.toString()).contains(
			"실행 결과",
			"a : -",
			"b : -",
			"a : --",
			"b : --",
			"a : ---",
			"b : ---",
			"a, b가 최종 우승했습니다."
		);
	}

	@DisplayName("차량 이름에 대한 예외 발생시 반복 입력 확인")
	@Test
	void run_WithInvalidLocation() {
		command(
			"", // 빈 입력
			"abcdef,g,h", // 글자수 초과
			"a,,b" // 이름에 쉼표가 들어가는 경우
		);
		try {
			assertTimeoutPreemptively(Duration.ofSeconds(1L), this::start);
		} catch (NoSuchElementException ignored) {
		}
	}

	@DisplayName("전진 횟수에 대한 예외 발생시 반복 입력 확인")
	@Test
	void run_WithInvalidTrialCount() {
		command(
			"", // 빈 입력
			"abc", // 문자 입력
			"-1" // 음수 입력
		);
		try {
			assertTimeoutPreemptively(Duration.ofSeconds(1L), this::start);
		} catch (NoSuchElementException ignored) {
		}
	}

	private void start() {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		// 차량이 항상 이동하도록 설정
		MovingStrategy movingStrategy = new MovingStrategy() {
			@Override
			public boolean canMove() {
				return true;
			}
		};
		RacingGame racingGame = new RacingGame(inputView, outputView, movingStrategy);

		racingGame.run();
	}

	private void command(final String... args) {
		final byte[] buf = String.join("\n", args).getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}
}
