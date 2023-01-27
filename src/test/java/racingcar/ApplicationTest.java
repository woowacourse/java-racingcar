package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private InputStream inputStream;

    @BeforeEach
    void setOutPrintStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void resetOutputStream() throws IOException {
        System.setOut(System.out);
        output.reset();
        inputStream.reset();
    }

    @Test
    void 어플리케이션_실행_통합_테스트() throws IOException {
        // given
        setOutPrintStream();
        어플리케이션_실행_통합_테스트_아웃풋();
        String expectedOutput = output.toString();
        resetOutputStream();

        String inputString = "jinho, dongh\n 3";
        inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        // when
        Application.main(new String[]{});
        String actualOutputString = output.toString();

        // then
        assertThat(actualOutputString).isEqualTo(expectedOutput);
    }

    void 어플리케이션_실행_통합_테스트_아웃풋() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        System.out.println("시도할 횟수는 몇회인가요?");

        System.out.println("실행 결과");
        System.out.println("jinho : -");
        System.out.println("dongh : -");
        System.out.println();

        System.out.println("jinho : --");
        System.out.println("dongh : --");
        System.out.println();

        System.out.println("jinho : ---");
        System.out.println("dongh : ---");
        System.out.println();

        System.out.println("최종 우승자 : jinho, dongh");
    }
}
