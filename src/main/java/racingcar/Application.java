package racingcar;

import racingcar.controller.GameController;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarRepository carRepository=new CarRepository();
        GameController game = new GameController(carRepository, inputView, outputView);
        game.play();
    }
}
