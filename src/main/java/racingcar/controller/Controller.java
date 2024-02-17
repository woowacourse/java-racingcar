package racingcar.controller;

import racingcar.model.RandomNumberGenerator;
import racingcar.view.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.Car;
import racingcar.model.Referee;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private List<Car> cars;
    private final Referee referee = new Referee();

    public void run() {
        List<String> carNames = inputView.getCarNames();
        int tryNumber = inputView.getTryNumber();
        generateCarList(carNames);
        outputView.printResultHeaderPrompt();
        while(tryNumber-- > 0){
            runRace();
        }
        outputView.printWinners(referee.generateWinners(cars));
    }

    private void runRace() {
        for(Car car : cars) {
            car.move();
            outputView.printResult(car.getName(), car.getPosition());
        }
        OutputView.parseLine();
    }

    private void generateCarList(List<String> carNames) {
        cars = new ArrayList<>();
        for(String carName : carNames){
            Car car = new Car(carName, new RandomNumberGenerator());
            cars.add(car);
        }
    }
}
