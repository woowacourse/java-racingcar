package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setOutPrintStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 어플리케이션_실행_통합_테스트() {
        // given
        List<InputStream> streams = Arrays.asList(
            new ByteArrayInputStream("jinho, dong\n".getBytes()),
            new ByteArrayInputStream("1".getBytes())
        );
        System.setIn(new SequenceInputStream(Collections.enumeration(streams)));

        // when
        Application.main(new String[]{});
        String actualOutputString = output.toString();

        // then
        assertAll(
            () -> assertThat(actualOutputString.contains("jinho : ")),
            () -> assertThat(actualOutputString.contains("dong : ")),
            () -> assertThat(actualOutputString.contains("최종 우승자 : "))
        );
    }
}
