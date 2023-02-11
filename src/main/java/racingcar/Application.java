package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.car.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        RacingController racingController = new RacingController(inputView, outputView);

        try {
            racingController.start(randomMovingStrategy);
        } catch (Exception e) {
            racingController.terminated(e.getMessage());
        }
    }
}
