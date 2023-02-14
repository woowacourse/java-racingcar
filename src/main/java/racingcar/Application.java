package racingcar;

import racingcar.controller.RacingController;
import racingcar.exception.DuplicateCarNamesException;
import racingcar.exception.ExceedCarNameLengthException;
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
        } catch (IllegalArgumentException e) {
            racingController.terminated(e);
        }
    }
}
