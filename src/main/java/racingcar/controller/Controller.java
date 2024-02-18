package racingcar.controller;

import java.sql.Ref;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.domain.Car;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<Car> cars = generateCarList(inputView.getCarNames());
        int tryNumber = inputView.getTryNumber();
        printResult(tryNumber, cars);
    }

    private List<Car> generateCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for(String carName : carNames){
            Car car = new Car(carName, new RandomNumberGenerator());
            cars.add(car);
        }

        return cars;
    }

    private void printResult(int tryNumber, List<Car> cars) {
        Referee referee = new Referee();
        outputView.printResultHeaderPrompt();

        while(tryNumber-- > 0){
            moveCars(cars);
        }

        outputView.printWinners(referee.generateWinners(cars));
    }

    private void moveCars(List<Car> cars) {
        for(Car car : cars) {
            car.move();
            outputView.printResult(car.getName(), car.getPosition());
        }

        OutputView.parseLine();
    }
}
