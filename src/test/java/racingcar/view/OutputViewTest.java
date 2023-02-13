package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OutputViewTest {

    private OutputStream outputStream;

    @BeforeEach
    void setMockOutput() {
        //테스트를 위해 System.out을 MockOutput으로 변경한다
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void setSystemOut() {
        //테스트가 끝나면 다시 원래의 out으로 변경한다
        System.setOut(System.out);
    }

    @Test
    void printWinner_메서드_테스트() {
        List<String> winners = List.of("judy", "nunu");
        OutputView.printWinner(winners);

//        assertThat(mockOutput.output()).contains("judy, nunu가 최종 우승했습니다.");
        assertThat(outputStream.toString()).contains("judy, nunu가 최종 우승했습니다.");
    }

    @Test
    void printStatusGuide_메서드_테스트() {
        OutputView.printStatusGuide();

        assertThat(outputStream.toString()).contains("실행 결과");
    }

    @Test
    void printStatus_메서드로_경주_진행상황_출력_테스트() {
        List<CarPositionDto> dtos = List.of(
                new CarPositionDto(1, "judy"),
                new CarPositionDto(2, "nunu"));
        OutputView.printStatus(dtos);

        assertThat(outputStream.toString()).contains("judy : -", "nunu : --");
    }
}
