import java.util.ArrayList;
import java.util.List;

public class Service {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winnerCars = new ArrayList<>();

    private static final int MOVEABLE_NUMBER = 4;
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int START_INDEX = 0;


    public void play() {
        creatCar();
        int count = checkInputCount();
        outputView.resultMessage();
        for (int index = START_INDEX; index < count; index++) {
            playUnit();
        }
        winners();
    }

    public void creatCar() {
        String[] inputCars = checkInputCarName();
        for (String carName : inputCars) {
            cars.add(new Car(carName));
        }
    }

    private void playUnit() {
        moveAllCars();
        printStatus();
        System.out.println();
    }

    private void winners() {
        selectWinners();
        outputView.printWinners(winnerCars);
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
        if (judgement(initRandomNumber())) {
            car.addPosition();
        }
    }

    public boolean judgement(int randomNumber) {
        return randomNumber >= MOVEABLE_NUMBER;
    }


    private int initRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_RANGE);
    }

    public void selectWinners() {
        for (Car car : cars) {
            addWinCar(car);
        }
    }

    public void addWinCar(Car car) {
        if (car.amIWinner(cars)) {
            winnerCars.add(car);
        }
    }


    private String[] checkInputCarName() {
        try {
            outputView.printStartMessage();
            return inputView.inputCarName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkInputCarName();
        }
    }

    private int checkInputCount() {
        try {
            outputView.printCountMessage();
            return inputView.inputCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkInputCount();
        }
    }
}
