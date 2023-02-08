package view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("현황을 형식에 맞게 출력하는지 테스트")
    void printStatus() {
        List<String> statuses = List.of("rosie : --", "hong : -");

        OutputView.printStatus(statuses);

        Assertions.assertThat(outputStream.toString())
                .isEqualTo("rosie : --\nhong : -\n\n");
    }

    @Test
    @DisplayName("우승자들을 형식에 맞게 출력하는지 테스트")
    void printWinners() {
        List<String> winners = List.of("rosie", "hong");

        OutputView.printWinners(winners);

        Assertions.assertThat(outputStream.toString())
                .isEqualTo("rosie, hong가 최종 우승했습니다.");
    }
}