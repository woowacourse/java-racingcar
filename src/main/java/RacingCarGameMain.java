import racingCar.Car;
import racingCar.Cars;
import view.InputView;
import view.OutputView;

public class RacingCarGameMain {
    public static void main(String[] args) {
        Cars cars = new Cars();

        initCars(cars);

        racingStart(cars);

        OutputView.showResult(cars);
    }

    private static void initCars(Cars cars) {
        String[] carNames = InputView.getInput().split(",");
        for (String carName : carNames) {
            cars.carAdd(new Car(carName));
        }
    }

    private static void racingStart(Cars cars) {
        int count = InputView.getTryNumber();
        for (int i = 0; i < count; i++) {
            cars.moveCar();
            OutputView.showStatus(cars.getCars());
        }
    }

}
