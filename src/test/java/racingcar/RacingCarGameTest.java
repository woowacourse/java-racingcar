package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Cars;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.*;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    Cars cars;
    OutputView outputView;
    InputView inputView;
    RacingGameController racingGameController = new RacingGameController(inputView, outputView, cars);

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
        racingGameController = new RacingGameController(inputView, outputView, cars);
        racingGameController.playGame();

        assertThat(out.toString()).contains("최종 우승했습니다.");
    }

    @DisplayName("자동차 경주 통합 예외 처리 후 정상 작동 테스트")
    @ParameterizedTest(name = "예외 = {1}")
    @MethodSource("playGameExceptionDummy")
    void playGameExceptionTest(String playGameExceptionInput, String kindOfException) {
        inputStream = new ByteArrayInputStream(playGameExceptionInput.getBytes(UTF_8));
        OutputStream out = new ByteArrayOutputStream();
        outputStream = new PrintStream(out);

        System.setIn(inputStream);
        System.setOut(outputStream);

        cars = new Cars();
        outputView = new OutputView();
        inputView = new InputView();
        racingGameController = new RacingGameController(inputView, outputView, cars);
        racingGameController.playGame();

        String gameTotalMessage = out.toString();
        assertThat(gameTotalMessage).contains("[ERROR]", "최종 우승했습니다.");
    }

    static Stream<Arguments> playGameExceptionDummy() {
        return Stream.of(
                Arguments.arguments("헤나, 썬샷, 헤나\n헤나, 썬샷\n5", "중복된 자동차 이름"),
                Arguments.arguments("헤나, 썬샷, 우아한테크코스\n헤나, 썬샷\n5", "5글자를 초과한 자동차 이름"),
                Arguments.arguments("헤나\n헤나, 썬샷\n5", "자동차 이름이 1개"),
                Arguments.arguments("헤나, 썬샷, 헤나\n헤나, 썬샷\n0\n5", "게임 라운드 입력이 0"),
                Arguments.arguments("헤나, 썬샷, 헤나\n헤나, 썬샷\n다섯번\n5", "게임 라운드 입력이 정수가 아님")
        );
    }
}
