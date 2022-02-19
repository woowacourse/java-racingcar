package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.numberGenerator.NumberGenerator;
import racingcar.numberGenerator.RandomNumberGenerator;
import racingcar.view.ErrorMessage;

class RacingGameTest {

    @DisplayName("play() 입력 값에 공백이 있는 경우 예외 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"name1,,name3", ",name1"})
    void play_input_empty_test(String inputNames) throws Exception {
        String[] input = {inputNames, "5"};
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        RacingGame racingGame = new RacingGame();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertThatThrownBy(() -> racingGame.play(numberGenerator))
                .hasMessageContaining(ErrorMessage.CAR_NAME_EMPTY.getMessage());
    }
}
