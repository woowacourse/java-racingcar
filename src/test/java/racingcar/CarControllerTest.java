package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.reader.ConsoleReader;

class CarControllerTest {

    OutputView outputView;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        out.reset();
        System.setOut(new PrintStream(out));
        outputView = new OutputView();
    }

    InputView setupInputStream(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        return new InputView(new ConsoleReader(System.in));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "101", "1000"})
    @DisplayName("횟수를 잘못 입력하는 경우 메시지를 출력한 뒤 다시 입력받는다.")
    void invalidInputRepeatTest(String input) {
        // given
        InputView inputView = setupInputStream("a,b,c\n" + input + "\n1\n");
        CarController controller = new CarController(inputView, outputView, () -> 9);
        // when
        controller.run();
        // then
        assertThat(out.toString())
                .containsSubsequence("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", "시도할 회수는 몇회인가요?", "[ERROR]",
                        "시도할 회수는 몇회인가요?", "실행 결과");
    }

    @Test
    @DisplayName("레이스를 정상적으로 실행한다.")
    void raceTest() {
        // given
        InputView inputView = setupInputStream("a,b,c\n3\n");
        OfInt iterator = IntStream.of(9, 9, 9, 9, 0, 9, 0, 0, 9).iterator();
        CarController controller = new CarController(inputView, outputView, iterator::nextInt);
        // when
        controller.run();
        // then
        assertThat(out.toString())
                .containsSubsequence(
                        "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                        "시도할 회수는 몇회인가요?",
                        "실행 결과",
                        "a : -",
                        "b : -",
                        "c : -",
                        "a : --",
                        "b : -",
                        "c : --",
                        "a : --",
                        "b : -",
                        "c : ---",
                        "c가 최종 우승했습니다"
                );
    }
}
