import racingCar.Car;
import racingCar.Cars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameMain {
    public static void main(String[] args) {
        Cars cars = new Cars(initCars());

        racingStart(cars);

        OutputView.showResult(cars);
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        String[] carNames = InputView.getInput().split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static void racingStart(Cars cars) {
        int count = InputView.getTryNumber();
        for (int i = 0; i < count; i++) {
            cars.moveCar();
            OutputView.showStatus(cars.getCars());
        }
    }

}
