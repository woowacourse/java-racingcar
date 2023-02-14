package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameTime;
import racingcar.domain.Winners;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {

    public static void main(String[] args) {

        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        try {
            Cars cars = new Cars(inputView.inputCarName());
            GameTime gameTime = new GameTime(inputView.inputGameTime());

            runGame(outputView, cars, gameTime);

            Winners winners = new Winners(cars);
            outputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runGame(OutputView outputView, Cars cars, GameTime gameTime) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        while (gameTime.isPlayable()) {
            cars.moveCars(numberGenerator);
            cars.getCars()
                    .forEach(
                            car -> outputView.printPosition(car.getCarName(), car.getPosition())
                    );
            System.out.println();
            gameTime.runOnce();
        }
    }
}
