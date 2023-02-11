package view;

import dto.CarDto;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("현황을 형식에 맞게 출력하는지 테스트")
    void printStatus() {
        List<CarDto> statuses = List.of(new CarDto("rosie", 2)
                , new CarDto("hong", 1));

        outputView.printStatus(statuses);

        Assertions.assertThat(outputStream.toString())
                .contains("rosie : --", "hong : -");
    }

    @Test
    @DisplayName("우승자들을 형식에 맞게 출력하는지 테스트")
    void printWinners() {
        List<CarDto> winners = List.of(new CarDto("rosie", 1),
                new CarDto("hong", 1));

        outputView.printWinners(winners);

        Assertions.assertThat(outputStream.toString())
                .isEqualTo("rosie, hong가 최종 우승했습니다.");
    }
}
