package racingcargame.domain;

import racingcargame.util.Spliter;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        String input = InputView.inputCarNames();
        String[] inputCarNames = Spliter.split(input);
        List<Car> cars = new ArrayList<>();
        for (String inputCarName : inputCarNames) {
            cars.add(new Car(inputCarName));
        }
        RacingCars racingCars = new RacingCars(cars);

        int tryLimitNumber = InputView.inputTryNumber();
        TryLimitNumber tryLimitNumber1 = new TryLimitNumber(tryLimitNumber);

        OutputView.printHead();
        int tryNumber = 0;
        while(tryLimitNumber1.isBiggerThan(tryNumber)){
            racingCars.go();
            OutputView.printPosition(racingCars);
            tryNumber++;
        }

        Winners winners = new Winners(racingCars.extractWinners());
        OutputView.printWinners(winners);
    }
}
