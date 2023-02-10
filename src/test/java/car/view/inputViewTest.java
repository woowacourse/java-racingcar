package car.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class inputViewTest {
    InputView inputView = new InputView(new testInputConsole());
    @Test
    @DisplayName("차 이름 입력 테스트")
    void 차_이름_입력_테스트(){
        inputView.inputCarNames();
    }

    @Test
    @DisplayName("시도 회수 입력 테스트")
    void 시도_횟수_입력_테스트(){
        inputView.inputTrialCount();
    }
}
