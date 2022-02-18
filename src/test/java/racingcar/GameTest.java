package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";

    @Test
    public void 게임시도횟수_음수_입력한_경우_예외발생() {
        List<Car> cars = CarFactory.of("kun,forky");
        int gameCount = -1;

        assertThatThrownBy(() -> new Game(cars, gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_ERROR_MESSAGE);
    }

    @Test
    public void 게임시도횟수_0_입력한_경우_Game_인스턴스_생성() {
        List<Car> cars = CarFactory.of("kun,forky");
        int gameCount = 0;

        Game game = new Game(cars, gameCount);

        assertThat(game).isInstanceOf(Game.class);
    }
}
