import domain.Car;
import domain.CarAccelerator;
import domain.Cars;
import domain.TryCount;
import io.InputView;
import io.OutputView;

import java.util.ArrayList;
import java.util.List;


public class CarRacing {
    private final InputView inputView;
    private final OutputView outputView;


    public CarRacing(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void start() {
        try {
            Cars cars = readCars();
            TryCount tryCount = createTryCount(inputView.readTryAmount());

            printMoveResult(tryCount, cars);
            printWinners(cars);
        } catch (Exception exception) {
            outputView.printErrorMessage(exception);
        }
    }

    private Cars readCars() {
        return createCars(inputView.readCarNames(), new CarAccelerator());
    }

    private void printWinners(Cars cars) {
        outputView.printWinners(getWinners(cars));
    }

    private void printMoveResult(TryCount tryCount, Cars cars) {
        outputView.printMoveResultMessage();
        tryMove(tryCount, cars);
    }

    public Cars createCars(List<String> carNames, CarAccelerator accelerator) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, accelerator));
        }

        return new Cars(cars);
    }

    public TryCount createTryCount(int amount) {
        return new TryCount(amount);
    }

    public void tryMove(TryCount tryCount, Cars cars) {
        for (int i = 0; i < tryCount.getValue(); i++) {
            cars.tryMove();
            outputView.printCarsPosition(cars.getCars());
        }
    }

    public List<String> getWinners(Cars cars) {
        int winnerPosition = cars.getWinnerPosition();

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .toList();
    }
}
