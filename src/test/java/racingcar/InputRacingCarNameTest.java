package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputRacingCarNameTest {

    private InputStream inputStream;

    @AfterEach
    void resetInputStream() throws IOException {
        inputStream.reset();
    }

    @Test
    void 자동차_이름_한개_입력_테스트() {
        //given
        Input input = new Input();

        // when
        String inputString = "jinho";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        List<String> carNamesList = input.getCarNamesList();

        // then
        assertThat(carNamesList.get(0)).isEqualTo(inputString);
    }
}