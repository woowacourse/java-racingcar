import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import controller.RacingGame;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Randoms;
import utils.moveNumberGenerator;

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


    @Test
    void run() {
        /*
         * 차량 3대를 3번 전진시키는데, 모든 차량을 3번 다 전진시키도록 설정
         */
        command("a,b,c", "3");
        RacingGame racingGame = new RacingGame(new moveNumberGenerator());

        racingGame.run();

        Assertions.assertThat(captor.toString()).contains(
                "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                "시도할 회수는 몇회인가요?",
                "실행 결과",
                "a : -",
                "b : -",
                "c : -",
                "a : --",
                "b : --",
                "c : --",
                "a : ---",
                "b : ---",
                "c : ---",
                "a, b, c가 최종 우승했습니다."
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
        RacingGame racingGame = new RacingGame(new Randoms());
        racingGame.run();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
