package racingcar;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
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
    void 게임_횟수_예외_발생시_입력_다시_받기() {
        //given
        setOutPrintStream();
        System.out.println("시도할 횟수는 몇회인가요?");
        System.out.println("[ERROR] 다시 입력하세요.");
        System.out.println("시도할 횟수는 몇회인가요?");
        String expectedOutput = output.toString();
        resetOutputStream();

        Input input = new Input();

        try {
            // when
            String inputString = "\n";
            inputStream = new ByteArrayInputStream(inputString.getBytes());
            System.setIn(inputStream);
            input.getRacingGameCount();
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