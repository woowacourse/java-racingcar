package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputRacingCarNameTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private InputStream inputStream;

    @AfterEach
    void resetInputStream() throws IOException {
        inputStream.reset();
    }

    @Test
    void 자동차_이름_한개_입력_테스트() {
        //given
        String inputString = "jinho";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Input input = new Input();

        // when
        List<String> carNamesList = input.getCarNamesList();

        // then
        assertThat(carNamesList.get(0)).isEqualTo(inputString);
    }

    @Test
    void 자동차_이름_여러개_입력_테스트() {
        //given
        String inputString = "jinho, dongho, skull";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        Input input = new Input();

        // when
        List<String> carNamesList = input.getCarNamesList();

        // then
        assertAll(
            () -> assertThat(carNamesList.get(0)).isEqualTo("jinho"),
            () -> assertThat(carNamesList.get(1)).isEqualTo("dongho"),
            () -> assertThat(carNamesList.get(2)).isEqualTo("skull")
        );
    }

    @Test
    void 자동차_이름에_공란_입력시_입력_다시_받기() {
        //given
        setOutPrintStream();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        System.out.println("[ERROR] 아무 이름도 입력하지 않으셨습니다. 다시 입력해주세요.");
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String expectedOutput = output.toString();
        resetOutputStream();

        Input input = new Input();

        try {
            // when
            String inputString = "\n";
            inputStream = new ByteArrayInputStream(inputString.getBytes());
            System.setIn(inputStream);

            input.getCarNamesList();

            failBecauseExceptionWasNotThrown(NoSuchElementException.class);
        } catch (NoSuchElementException e) {
            // then
            String actualOutput = output.toString();
            assertThat(actualOutput).isEqualTo(expectedOutput);
        } finally {
            resetOutputStream();
        }
    }

    void setOutPrintStream() {
        System.setOut(new PrintStream(output));
    }

    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }
}