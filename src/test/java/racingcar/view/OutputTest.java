package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racingcar.domain.Car;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void 자동차_이름_출력_검증() {
        Car car = new Car("pobi");
        Output.printName(car);
        assertThat(outContent.toString()).contains("pobi :");
    }

    @Test
    void 우승자_출력_검증() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("jun");

        Output.printWinner(winners);
        assertThat(outContent.toString()).contains("pobi, jun가 최종 우승했습니다.");
    }

    @Test
    void 현재_위치_출력_검증() {
        Car car = new Car("pobi", 3);
        Output.printPositionWord(car);

        assertThat(outContent.toString()).contains("---");
    }
}
