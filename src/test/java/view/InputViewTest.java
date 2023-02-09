package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputViewTest {
    private InputView inputView;
    private MockOutput mockOutput;

    @BeforeEach
    void setMockOutput() {
        mockOutput = new MockOutput();
        inputView = new InputView(mockOutput);
    }

    @Test
    void printInputTryCountGuide_메서드_테스트() {
        inputView.printInputTryCountGuide();

        assertThat(mockOutput.output()).isEqualTo("시도할 회수는 몇회인가요?\n");
    }

    @Test
    void printInputCarNameGuide_메서드_테스트() {
        inputView.printInputCarNameGuide();

        assertThat(mockOutput.output()).isEqualTo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
    }
}
