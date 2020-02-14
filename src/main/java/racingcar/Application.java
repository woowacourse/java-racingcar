package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceResult;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String inputNames = InputView.receiveNameInput();
        Cars cars = new Cars(inputNames);

        int countInput = InputView.receiveCountInput();
        TryCount tryCount = new TryCount(countInput);

        OutputView.showResult();
        showRaceResult(cars, tryCount);
    }

    private static void showRaceResult(Cars cars, TryCount tryCount) {
        Race race = new Race();
        RaceResult raceResult = new RaceResult();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            race.startRace(cars);
            List<Car> carGroup = cars.getCars();
            OutputView.showEachRaceResult(raceResult.getEachRaceResult(carGroup));
        }

        List<String> winnerGroup = cars.getWinners();
        OutputView.showWinners(raceResult.getWinnerNames(winnerGroup));
    }
}