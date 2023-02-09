package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.MockRandomPicker;
import racingcar.view.InputView;
import racingcar.view.MockInput;
import racingcar.view.MockOutput;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ControllerTest {
    private Controller controller;
    private MockOutput mockOutput;

    @BeforeEach
    void setController() {
        mockOutput = new MockOutput();
        controller = new Controller(new MockRandomPicker(), new MockInput(),
                new OutputView(mockOutput),
                new InputView(mockOutput));
    }

    @Test
    void raceTracks_메서드_테스트() {
        controller.raceTracks();

        assertThat(mockOutput.output())
                .contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                        "시도할 회수는 몇회인가요?",
                        "judy, pobi가 최종 우승했습니다");
    }

}
