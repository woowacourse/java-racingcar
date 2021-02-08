import racingCar.Car;
import racingCar.Cars;
import view.InputView;
import view.OutputView;

public class RacingCarGameMain {
    public static void main(String[] args) {
        Cars cars = new Cars();

        String[] carNames = InputView.getInput().split(",");

        for (String carName : carNames) {
            cars.carAdd(new Car(carName));
        }

        cars.playGame(InputView.getTryNumber());

        OutputView.showResult(cars);
    }
}
