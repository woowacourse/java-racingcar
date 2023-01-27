package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class InputTest {

    private InputStream inputStream;

    @Test
    void 게임_횟수_입력_테스트() {
        //given
        String inputString = "10";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        int expectedInput = 10;

        Input input = new Input();

        // when
        int actualInput = input.getRacingGameCount();

        // then
        assertThat(expectedInput).isEqualTo(actualInput);
    }
}