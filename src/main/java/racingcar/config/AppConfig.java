package racingcar.config;

import racingcar.domain.Game;
import racingcar.domain.RacingCarGame;
import racingcar.domain.Rule;

public class AppConfig {
    public static Game getGame() {
        return new RacingCarGame(ViewConfig.getInputView(), ViewConfig.getOutputView(), ViewConfig.getErrorView());
    }

    public static Rule getRule() {
        return new Rule(MovementStrategyConfig.getMovementStrategy());
    }
}
