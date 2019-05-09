package racing;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RepeatNumber;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racing.view.InputView.inputCarNames;

public class RacingGame {
    public void run() {
        String[] carNames = getCarNames();
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        RacingCars racingCars = new RacingCars(carList);

        RepeatNumber repeatNumber = InputView.inputRepeatNumber();

        for (int i = 1; i <= repeatNumber.getRepeatNumber(); i++) {
            racingCars.race();
            OutputView.printStatus(racingCars.getRaceStatus());
        }
        OutputView.printWinners(racingCars.getWinners());

    }

    private String[] getCarNames() {
        return inputCarNames().split(",");
    }
}
