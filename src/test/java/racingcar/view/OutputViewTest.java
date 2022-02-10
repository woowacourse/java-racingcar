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

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("psotion을 -로 출력한다.")
    void printCarsPosition() {
        OutputView outputView = new OutputView();
        List<RacingCarDto> racingCarDtos = Arrays.asList(
            new RacingCarDto("pobi", 2),
            new RacingCarDto("crong", 3)
        );
        outputView.printCarsPosition(racingCarDtos);
        assertThat(outContent.toString()).isEqualTo("pobi : --\ncrong : ---\n\n");
    }

    @Test
    @DisplayName(", 를 구분자로 우승자를 출력한다.")
    void printWinnerNames() {
        OutputView outputView = new OutputView();
        List<String> winnerNames = Arrays.asList("pobi", "crong", "honux");
        outputView.printWinnerNames(winnerNames);
        assertThat(outContent.toString()).isEqualTo("pobi, crong, honux가 최종 우승했습니다.\n");
    }
}