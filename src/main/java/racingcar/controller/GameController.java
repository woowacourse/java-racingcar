package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private static final String SPLIT_DELIM = ",";

    public void play() {
        Cars cars = makeCarsFromNames(Input.getCarNamesSeperatedByDelimiter(SPLIT_DELIM));
        int tryNum = Input.getTryNum();

        runRaceTryTimes(cars, tryNum);

        Output.printWinner(cars.findAllWinners());
    }

    private Cars makeCarsFromNames(List<String> names) {
        return new Cars(names.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList()));
    }

    private void runRaceTryTimes(Cars cars, int tryNum) {
        Output.printStartRace();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        for (int i = 0; i < tryNum; i++) {
            cars.moveAll(randomMoveStrategy);
            Output.printCarsStatus(cars.getCars());
            Output.printBlankLine();
        }
    }
}
