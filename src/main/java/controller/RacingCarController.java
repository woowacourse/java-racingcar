package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.Cars;
import domain.Referee;
import output.Outputs;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public void run() {
        List<String> carNames = InputView.readCarName();
        int attemptNumber = InputView.readAttemptNumber();

        Cars cars = makeCarsFromNames(carNames);

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

    private Cars makeCarsFromNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
