package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class InputTest {
    private InputStream input;

    @Test
    void 게임_횟수_입력_테스트() {
        String inputString = "10";
        input = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(input);
        int expectedInput = Integer.parseInt(new Scanner(System.in).nextLine());

        Input input = new Input();
        int actualInput = input.getRacingGameCount();

        assertThat(expectedInput).isEqualTo(actualInput);
    }
}