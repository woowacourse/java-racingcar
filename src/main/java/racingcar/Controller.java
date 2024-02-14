package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final InputValidator inputValidator = new InputValidator();
    List<Car> cars;

    public void run() {
        List<String> carNames = inputView.getCarNames();
        inputValidator.validateAvailableCarNames(carNames);
        int tryNumber = inputView.getTryNumber();
        generateCarList(carNames);
        outputView.printResultPrompt();
        while(tryNumber != 0){
            runRace();
            tryNumber--;
        }

    }

    private void runRace() {
        for(Car car : cars) {
            car.move();
            outputView.printResult(car.getName(), car.getPosition());
            System.out.println();
        }
    }

    private void generateCarList(List<String> carNames) {
        cars = new ArrayList<>();
        for(String carName : carNames){
            Car car = new Car(carName);
            cars.add(car);
        }
    }
}
