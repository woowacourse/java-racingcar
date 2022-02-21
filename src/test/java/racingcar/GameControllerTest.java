package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.numbergenerator.MovableNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameControllerTest {
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";

    @Test
    public void 게임시도횟수_음수_입력한_경우_예외발생() {
        List<Car> cars = CarFactory.from("kun,forky");
        GameController gameController = new GameController();
        int gameCount = -1;

        assertThatThrownBy(() -> gameController.createGameCount(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_ERROR_MESSAGE);

    }

    @Test
    public void 우승자_판정_1명() {
        GameController gameController = new GameController();
        String name = "pobi";
        gameController.createCars("pobi,kun");
        gameController.move(new MovableNumberGenerator());
        assertThat(gameController.judgeWinner().getWinnerCarNames().get(0)).isEqualTo(name);
    }

    @Test
    public void 우승자_여러명() {
        GameController gameController = new GameController();
        gameController.createCars("kun,forky");

        gameController.move(new MovableNumberGenerator());

        assertThat(gameController.judgeWinner().getWinnerCarNames().size()).isEqualTo(2);
    }
}
