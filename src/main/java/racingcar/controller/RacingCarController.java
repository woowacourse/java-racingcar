package racingcar.controller;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {
    private final Racing racing = new Racing();

    public void run() {
        OutPutView.printResult(racing.race(getCars(), InputView.getCount()));
    }

    private List<Car> getCars() {
        return Arrays.stream(InputView.getCarNames())
            .map(carName -> new Car(carName, new RandomMovingPolicy()))
            .collect(toList());
    }
}
