import java.util.ArrayList;
import java.util.List;

public class Service {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<Car> cars = new ArrayList<>();

    public void creatCar() {
        outputView.printStartMessage();
        String[] inputCars = inputView.inputCarName();
        for (String carName : inputCars) {
            cars.add(new Car(carName));
        }
    }
}
