package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.numbergenerator.MovableNumberGenerator;
import racingcar.numbergenerator.NumberGenerator;
import racingcar.numbergenerator.RandomNumberGenerator;
import racingcar.numbergenerator.UnMovableNumberGenerator;
import racingcar.view.ErrorMessage;

class RacingGameTest {

    @DisplayName("play() 움직임이 있는 경우 테스트")
    @Test
    void play_movable_test() {
        String[] input = {"name1,name2", "1"};
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        RacingGame racingGame = new RacingGame();
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        racingGame.play(numberGenerator);
        assertThat(output.toString()).isEqualTo(
                "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n" +
                        "시도할 회수는 몇회인가요?\n" +
                        "\n" +
                        "실행 결과\n" +
                        "name1 : -\n" +
                        "name2 : -\n" +
                        "\n" +
                        "name1, name2가 최종 우승했습니다.");
    }

    @DisplayName("play() 움직임이 없는 경우 테스트")
    @Test
    void play_unMovable_test() {
        String[] input = {"name1,name2", "1"};
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        RacingGame racingGame = new RacingGame();
        NumberGenerator numberGenerator = new UnMovableNumberGenerator();
        racingGame.play(numberGenerator);
        assertThat(output.toString()).isEqualTo(
                "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n" +
                        "시도할 회수는 몇회인가요?\n" +
                        "\n" +
                        "실행 결과\n" +
                        "name1 : \n" +
                        "name2 : \n" +
                        "\n" +
                        "name1, name2가 최종 우승했습니다.");
    }

    @DisplayName("play() 입력 값에 공백이 있는 경우 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"name1,,name3", ",name1"})
    void play_input_empty_test(String inputNames) {
        String[] input = {inputNames, "5"};
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        RacingGame racingGame = new RacingGame();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertThatThrownBy(() -> racingGame.play(numberGenerator))
                .hasMessageContaining(ErrorMessage.CAR_NAME_EMPTY.getMessage());
    }
}
