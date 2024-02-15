import java.util.ArrayList;
import java.util.List;

public class GameManager {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView(outputView);
    List<Car> cars = new ArrayList<>();

    public void run() {
        List<String> carNames = inputView.getCarName();
        makeNewCars(carNames);
        int tryCount = inputView.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            outputView.printTryResult(cars);
        }
        outputView.printWinners(cars);
    }

    private void moveCars() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    private void makeNewCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
