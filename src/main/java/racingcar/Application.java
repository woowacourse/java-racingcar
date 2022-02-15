package racingcar;

import racingcar.builder.GameControllerBuilder;
import racingcar.controller.GameController;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameControllerBuilder gameControllerBuilder = new GameControllerBuilder();

        GameController gameController = gameControllerBuilder
                .setInputView(new InputView())
                .setOutputView(new OutputView())
                .setCarRepository(new CarRepository())
                .build();

        gameController.play();
    }
}
