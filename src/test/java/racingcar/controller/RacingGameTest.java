package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ErrorMessage;

public class RacingGameTest {

    @DisplayName("play() 입력 값에 공백이 있는 경우 예외 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"name1,,name3", ",name1"})
    public void play_input_empty_test(String inputNames) throws Exception {
        String[] input = {inputNames, "5"};
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.play())
                .hasMessageContaining(ErrorMessage.CAR_NAME_EMPTY.getMessage());
    }
}
