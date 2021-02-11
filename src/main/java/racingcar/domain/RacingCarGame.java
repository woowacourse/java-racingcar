package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public void start() {
        try {
            List<String> splittedCarNames = InputView.getCarNamesInput();
            Cars cars = createRacingCars(splittedCarNames);
            int lap = InputView.getLapInput();
            race(cars, lap);
            OutputView.showWinners(cars.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Cars createRacingCars(List<String> carNames) {
        List<Car> value = new ArrayList<>();
        carNames.forEach(carName -> value.add(new Car(new CarName(carName))));
        return new Cars(value);
    }

    private void race(Cars cars, int lap) {
        OutputView.showResultMessage();
        for (int i = 0; i < lap; i++) {
            cars.raceOneLap();
            OutputView.showOneLapResult(cars.getStatus());
        }
    }
}
