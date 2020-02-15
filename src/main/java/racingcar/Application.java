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
        Cars cars = createCars();;

        TryCount tryCount = receiveTryCount();

        OutputView.showResult();
        showRaceResult(cars, tryCount);
    }

    private static Cars createCars() {
        try {
            String nameInput = InputView.receiveNameInput();
            return new Cars(nameInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCars();
        }
    }

    private static TryCount receiveTryCount() {
        try {
            int countInput = InputView.receiveCountInput();
            return new TryCount(countInput);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해야 합니다.");
            return receiveTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return receiveTryCount();
        }
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