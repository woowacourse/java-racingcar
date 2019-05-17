import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = InputView.readCarsUntilSucceed(new CarFactory());
        int numTrials = InputView.readNumTrialsUntilSucceed();

        OutputView.printMassage("실행결과");
        RacingGame racingGame = new RacingGame(numTrials);

        while (!racingGame.isFinished()) {
            cars = racingGame.playTrial(cars);
            OutputView.printCars(cars);
        }
        OutputView.printWinners(MaxFinder.findAllMax(cars, Car.POSITION_COMPARATOR));
    }
}
