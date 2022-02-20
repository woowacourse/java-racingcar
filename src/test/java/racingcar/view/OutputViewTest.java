package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarDto;

class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName(", 를 구분자로 우승자를 출력한다.")
    void printWinnerNames() {
        List<String> winnerNames = Arrays.asList("pobi", "crong", "honux");
        OutputView.printWinnerNames(winnerNames);
        assertThat(outContent.toString()).isEqualTo("pobi, crong, honux가 최종 우승했습니다.\n");
    }
}