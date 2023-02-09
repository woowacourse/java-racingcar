package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingStatusDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OutputViewTest {
    private OutputView outputView;
    private MockOutput mockOutput;

    @BeforeEach
    void setMockOutput() {
        mockOutput = new MockOutput();
        outputView = new OutputView(mockOutput);
    }

    @Test
    void printWinner_메서드_테스트() {
        List<String> winners = List.of("judy", "nunu");
        outputView.printWinner(winners);

        assertThat(mockOutput.output()).contains("judy, nunu가 최종 우승했습니다.");
    }

    @Test
    void printStatusGuide_메서드_테스트() {
        outputView.printStatusGuide();

        assertThat(mockOutput.output()).contains("실행 결과");
    }

    @Test
    void printStatus_메서드로_경주_진행상황_출력_테스트() {
        List<RacingStatusDto> dtos = List.of(
                new RacingStatusDto(1, "judy"),
                new RacingStatusDto(2, "nunu"));
        outputView.printStatus(dtos);

        assertThat(mockOutput.output()).contains("judy : -", "nunu : --");
    }
}
