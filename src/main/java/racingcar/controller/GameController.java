package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GameController {
    public void play() {
        Cars cars = makeCarsFromNames(Input.getCarNames());
        int tryNum = Input.getTryNum();

        runRaceTryTimes(cars, tryNum);

        Output.printWinner(cars.findAllWinners());
    }

    private Cars makeCarsFromNames(String[] names) {
        return new Cars(Arrays.stream(names)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList()));
    }

    private void runRaceTryTimes(Cars cars, int tryNum) {
        Output.printStartRace();
        for (int i = 0; i < tryNum; i++) {
            cars.moveAllByRandom();
            Output.printCarsStatus(cars.getCars());
            Output.printBlankLine();
        }
    }
}
