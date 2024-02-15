import java.util.ArrayList;
import java.util.List;

public class RacingcarApplication {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        List<Car> cars = new ArrayList<>();

        List<String> carNames = inputView.getCarName();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        int tryCount = inputView.getTryCount();
        for(int i = 0 ;i<tryCount;i++) {
            for (Car car : cars) {
                car.moveCar();
            }
            outputView.printTryResult(cars);
        }
        outputView.printWinners(cars);
    }
}
