package domain;

import controller.RacingCarController;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

class RacingCarGameTest {
    private final RacingCarController controller = new RacingCarController(new OutputView(), new InputView());
    private RacingCarGame racingCarGame = new RacingCarGame(controller.setCars(List.of("ash", "lily")));

    @DisplayName("입력한 시도 횟수만큼 경주를 진행한다")
    @Test
    void playGameTest() {
        Assertions.assertThatCode(() -> racingCarGame.playGame(3))
                .doesNotThrowAnyException();
    }

    @DisplayName("최종 우승자를 올바르게 결정한다")
    @Test
    void getWinnerNameTest() {
        Cars cars = controller.setCars(List.of("ash", "lily"));
        racingCarGame = new RacingCarGame(cars);
        cars.getCars().get(0).incLocation();
        Assertions.assertThat(racingCarGame.getWinnerName()).isEqualTo(List.of("ash"));
    }
}
