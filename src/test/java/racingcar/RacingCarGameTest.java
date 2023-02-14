package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.*;

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

    @DisplayName("중복된 자동차 이름이 입력되면 오류 메시지를 출력한다.")
    @Test
    void duplicateCarNames() {
        shouldBeError("헤나, 썬샷, 헤나\n헤나, 썬샷\n5");
    }

    @DisplayName("다섯 글자를 초과하는 자동차 이름이 입력되면 오류 메시지를 출력한다.")
    @Test
    void overFiveLengthCarNames() {
        shouldBeError("헤나, 썬샷, 우아한테크코스\n헤나, 썬샷\n5");
    }

    @DisplayName("한 개의 자동차 이름만 입력되면 오류 메시지를 출력한다.")
    @Test
    void onlyOneCarNames() {
        shouldBeError("헤나\n헤나, 썬샷\n5");
    }

    @DisplayName("게임 라운드 입력이 0으로 시작하는 경우 오류 메시지를 출력한다.")
    @Test
    void startsWithZeroGameRound() {
        shouldBeError("헤나, 썬샷, 루카\n0\n5");
    }

    @DisplayName("게임 라운드 입력이 정수가 아닌 경우 오류 메시지를 출력한다.")
    @Test
    void notIntegerGameRound() {
        shouldBeError("헤나, 썬샷, 루카\na\n5");
    }

    private void shouldBeError(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes(UTF_8));
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
}
