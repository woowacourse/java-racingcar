package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.Cars;
import domain.Referee;
import output.Outputs;
import utils.Names;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public void run() {
        Names names = InputView.readNames();
        int attemptNumber = InputView.readAttemptNumber();

        Cars cars = makeCarsFrom(names);

        OutputView.printResult();

        while ((attemptNumber--) > 0) {
            moveAll(cars);
            Outputs outputs = Outputs.from(cars);
            OutputView.printCars(outputs);
        }

        Referee referee = new Referee();
        Cars winner = referee.judgeWinner(cars);
        OutputView.printWinner(winner);
    }

    private void moveAll(Cars cars) {
        cars.getStream()
                .forEach((car) -> car.move(RandomNumberGenerator.generate()));
    }

    private Cars makeCarsFrom(Names names) {
        List<Car> cars = names.getStream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
