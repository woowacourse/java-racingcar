package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.car.CarFactory;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.car.strategy.RandomMovingStrategy;
import racingcar.model.track.Track;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        CarFactory carFactory = new CarFactory(randomMovingStrategy);

        RacingController racingController = new RacingController(inputView, outputView, carFactory);
        try {
            Track track = racingController.generateRacingTrack();

            racingController.startRace(track);
            racingController.concludeWinner(track);
        } catch (Exception exception) {
            racingController.terminated(exception.getMessage());
        }
    }
}
