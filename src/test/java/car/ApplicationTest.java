package car;

import car.controller.GameController;
import car.domain.Car;
import car.view.InputView;
import car.view.OutputTestStream;
import car.view.TestInputConsole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApplicationTest extends OutputTestStream {
    private TestInputConsole testInputConsole = new TestInputConsole();
    @Test
    @DisplayName("게임_실행_테스트")
    void 게임_실행_테스트(){
        testInputConsole.setCarNames("땡칠,호이,달리,루쿠,저문,아마란스");
        testInputConsole.setTestTrialCount("5");
        runGame();
        assertThat(output())
                .contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                        "시도할 회수는 몇회인가요?",
                        " :",
                        "가 최종 우승했습니다.");
    }

    @ParameterizedTest(name = "이름 길이가 1글자 이상 5글자 이하인지 확인하는 테스트")
    @ValueSource(strings = {"", "aaaaaa"})
    void 이름_길이_1글자이상_5글자_이하이다(String provided) {
        testInputConsole.setCarNames(provided);
        assertThatThrownBy(() -> runGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void runGame(){
        GameController gameController = new GameController(testInputConsole);
        gameController.startGame();
        gameController.play();
        gameController.showResult();
    }
}
