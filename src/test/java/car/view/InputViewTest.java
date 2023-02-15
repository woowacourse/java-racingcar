package car.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest extends OutputTestStream {
    InputView inputView;
    TestInputConsole testInputConsole = new TestInputConsole();

    @BeforeEach
    void setInputView() {
        this.inputView = new InputView(this.testInputConsole);
    }

    @Test
    @DisplayName("차 이름 입력 테스트")
    void 차_이름_입력_테스트() {
        testInputConsole.setCarNames("땡칠,호이,달리,루쿠,저문,아마란스");
        assertThat(inputView.inputCarNames()).contains("땡칠", "호이", "달리", "루쿠", "저문", "아마란스");
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Test
    void 공백있는_차이름_입력시_공백_제거하는_테스트(){
        testInputConsole.setCarNames("땡칠 ,호이 ,달리 ,루쿠  ,저문 , 아마란스");
        assertThat(inputView.inputCarNames()).contains("땡칠", "호이", "달리", "루쿠", "저문", "아마란스");
    }

    @Test
    @DisplayName("시도 회수 입력 테스트")
    void 시도_횟수_입력_테스트() {
        testInputConsole.setTestTrialCount("10");
        assertThat(inputView.inputTrialCount()).isEqualTo(10);
        assertThat(output()).contains("시도할 회수는 몇회인가요?");
    }
}
