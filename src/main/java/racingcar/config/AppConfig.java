package racingcar.config;

import racingcar.domain.Game;
import racingcar.domain.RacingCarGame;

public class AppConfig {
    public static Game getGame() {
        return new RacingCarGame(ViewConfig.getInputView(), ViewConfig.getOutputView(), ViewConfig.getErrorView());
    }
}
