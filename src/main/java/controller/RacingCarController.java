package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.Cars;
import output.Outputs;
import utils.Names;
import utils.RepeatCount;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public void run() {
        Names names = InputView.readNames();
        RepeatCount repeatCount = InputView.readRepeatCount();
        OutputView.printTitle();

        Cars cars = makeCarsFrom(names);
        while (repeatCount.hasNext()) {
            cars.move();
            Outputs outputs = Outputs.from(cars);
            OutputView.printOutputs(outputs);
        }

        Cars winners = cars.judgeWinners();
        OutputView.printWinners(winners);
    }

    private Cars makeCarsFrom(Names names) {
        List<Car> cars = names.getStream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
