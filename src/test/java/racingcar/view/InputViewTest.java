package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputViewTest {

    private InputView inputView;
    private MockOutput mockOutput;

    @BeforeEach
    void setMockOutput() {
        mockOutput = new MockOutput();
        inputView = new InputView(mockOutput, new MockInput());
    }

    @Test
    void printInputTryCountGuide_메서드_테스트() {
        inputView.inputTryCount();

        assertThat(mockOutput.output()).isEqualTo("시도할 회수는 몇회인가요?\n");
    }

    @Test
    void printInputCarNameGuide_메서드_테스트() {
        inputView.inputCarName();

        assertThat(mockOutput.output()).isEqualTo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
    }
}
