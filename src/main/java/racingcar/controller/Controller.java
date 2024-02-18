package racingcar.controller;

import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.Car;
import racingcar.model.Referee;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Referee referee = new Referee();

        List<String> carNames = inputView.getCarNames();
        int tryNumber = inputView.getTryNumber();

        List<Car> cars = generateCarList(carNames);

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

    private List<Car> generateCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for(String carName : carNames){
            Car car = new Car(carName, new RandomNumberGenerator());
            cars.add(car);
        }

        return cars;
    }
}
