package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.car.move.DefaultMovingStrategy;
import racingcar.domain.car.move.MovingStrategy;
import racingcar.domain.car.move.generator.NumberGenerator;
import racingcar.domain.car.move.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.console.ConsoleInputView;
import racingcar.view.console.ConsoleOutputView;

public class AppConfig {
    private AppConfig() {
    }

    public static InputView consoleInputView() {
        return new ConsoleInputView();
    }

    public static OutputView consoleOutputView() {
        return new ConsoleOutputView();
    }

    public static NumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public static MovingStrategy defaultMovingStrategy() {
        return new DefaultMovingStrategy(randomNumberGenerator());
    }

    public static RacingController racingController() {
        return new RacingController(
                consoleInputView(),
                consoleOutputView(),
                defaultMovingStrategy()
        );
    }
}
