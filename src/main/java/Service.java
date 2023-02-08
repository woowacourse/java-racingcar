import java.util.ArrayList;
import java.util.List;

public class Service {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winners = new ArrayList<>();

    private static final int MOVEABLE_NUMBER = 4;
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int START_INDEX = 0;


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
        return initRandomNumber() >= MOVEABLE_NUMBER;
    }


    public int initRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_RANGE);
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


    public void play() {
        creatCar();
        outputView.printCountMessage();
        int count = inputView.inputCount();
        outputView.resultMessage();
        for (int index = START_INDEX; index < count; index++) {
            moveAllCars();
            printStatus();
            System.out.println();
        }
        selectWinners();
        outputView.printWinners(winners);
    }
}
