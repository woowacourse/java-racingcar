import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final MoveStrategy moveStrategy = new MoveStrategy();

    public static void main(String[] args) {
        List<Car> cars = InputView.readCarsUntilSucceed(new CarFactory());
        int numTrials = InputView.readNumTrialsUntilSucceed();

        OutputView.printMassage("실행결과");
        RacingGame racingGame = new RacingGame(cars, numTrials);

        List<MovedCar> movedCars = new ArrayList<>();
        while (!racingGame.isFinished()) {
            movedCars = racingGame.playTrial(moveStrategy);
            OutputView.printCars(movedCars);
        }
        OutputView.printWinners(MaxFinder.findAllMax(movedCars, MovedCar.positionComparator));
    }
}
