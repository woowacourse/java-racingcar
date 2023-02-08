import java.util.ArrayList;
import java.util.List;

public class Service {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winners = new ArrayList<>();

    public void creatCar() {
        outputView.printStartMessage();
        String[] inputCars = inputView.inputCarName();
        for (String carName : inputCars) {
            cars.add(new Car(carName));
        }
    }


    private void printStatus() {
        for (Car car : cars) {
            outputView.printStatus(car.getName(), car.getPosition());
        }
    }

    public void moveAllCars() {
        for (Car car : cars) {
            move(car);
        }
    }

    public void move(Car car) {
        if (judgement()) {
            car.addPosition();
        }
    }

    public boolean judgement() {
        return initRandomNumber() >= 4;
    }


    public int initRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public void selectWinners() {
        for (Car car : cars) {
            addWinCar(car);
        }
    }

    private void addWinCar(Car car) {
        if (car.amIWinner(cars)) {
            winners.add(car);
        }
    }
}
