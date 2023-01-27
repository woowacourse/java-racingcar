package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputTest {

    private InputStream inputStream;

    @AfterEach
    void resetInputStream() throws IOException {
        inputStream.reset();
    }

    @Test
    void 게임_횟수_입력_테스트() {
        //given
        Input input = new Input();

        // whne
        String inputString = "10";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        int actualInput = input.getRacingGameCount();
        int expectedInput = 10;

        // then
        assertThat(expectedInput).isEqualTo(actualInput);
    }

    @Test
    void 게임_횟수_입력에_공란을_입력하면_에러_반환_테스트() {
        //given
        Input input = new Input();

        // when
        String inputString = "\n";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        // then
        assertThatThrownBy(input::getRacingGameCount)
            .isInstanceOf(IllegalArgumentException.class);
    }
}