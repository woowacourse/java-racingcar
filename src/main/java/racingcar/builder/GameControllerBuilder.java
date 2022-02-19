package racingcar.builder;

import racingcar.controller.GameController;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControllerBuilder {
    private InputView inputView;
    private OutputView outputView;
    private CarRepository carRepository;

    public GameControllerBuilder setInputView(InputView inputView) {
        this.inputView = inputView;
        return this;
    }

    public GameControllerBuilder setOutputView(OutputView outputView) {
        this.outputView = outputView;
        return this;
    }

    public GameControllerBuilder setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
        return this;
    }

    public GameController build() {
        GameController gameController = new GameController(inputView, outputView, carRepository);
        return gameController;
    }
}
