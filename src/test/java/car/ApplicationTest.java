package car;

import car.controller.GameController;
import car.view.OutputTestStream;
import car.view.testInputConsole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApplicationTest extends OutputTestStream {
    @Test
    @DisplayName("게임_실행_테스트")
    void 게임_실행_테스트(){
        GameController gameController = new GameController(new testInputConsole());
        gameController.startGame();
        gameController.play();
        gameController.showResult();
        assertThat(output())
                .contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
                        "시도할 회수는 몇회인가요?",
                        " :",
                        "가 최종 우승했습니다.");
    }
}
