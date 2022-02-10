package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;


public class InputTest {

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 이름_입력_성공() {
        systemIn("ab,cd,ef");
        String[] names = Input.insertRightName();
        Assertions.assertThat(names).contains("ab", "cd", "ef");
    }

}
