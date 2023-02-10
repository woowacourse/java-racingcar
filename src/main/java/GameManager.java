import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<String> winnerCars = new ArrayList<>();
    private final CarRepositoryInterface carRepositoryInterface = new CarRepository();

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
            carRepositoryInterface.saveCar(new Car(carName));

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
        for (String carName : carRepositoryInterface.carNames()) {
            outputView.printStatus(carName, carRepositoryInterface.findPositionByName(carName));
        }
    }

    public void moveAllCars() {
        for (String carName : carRepositoryInterface.carNames()) {
            move(carName);
        }
    }

    public void move(String carName) {
        if (judgement(initRandomNumber())) {
            carRepositoryInterface.addPosition(carName);
        }
    }

    public boolean judgement(int randomNumber) {
        return randomNumber >= MOVEABLE_NUMBER;
    }


    private int initRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_RANGE);
    }

    public void selectWinners() {
        winnerCars.addAll(carRepositoryInterface.findNameByPosition(maxPosition()));
    }

    public int maxPosition() {
        return Collections.max(carRepositoryInterface.positions());
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
