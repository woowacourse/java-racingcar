package controller;

import domain.MockRandomPicker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.MockInput;
import view.MockOutput;
import view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
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
