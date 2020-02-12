package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private static final String DELIMITER = ",";

    private ArrayList<Car> cars = new ArrayList<>();
    private int times;

    public void run() {
        setName();
        setRepeat();
        processGame();
        getGameResult();
    }

    private void getGameResult() {
        RacingCars racingCars = new RacingCars(cars);
        List<Car> winnerCar = racingCars.getWinner();
        OutputView.winnerInstruction(racingCars.getWinnerName(winnerCar));
    }

    private void processGame() {
        OutputView.newLine();
        OutputView.resultInstruction();
        for (int i = 0; i < times; i++) {
            processOneTime();
            OutputView.newLine();
        }
    }

    private void processOneTime() {
        for (Car car : cars) {
            car.decideGoOrStop(createRandomNumber());
            OutputView.carNameAndPosition(car);
        }
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private void setRepeat() {
        OutputView.inputRepeatInstruction();
        times = InputView.inputRepeat();
    }

    private void setName() {
        OutputView.inputNameInstruction();
        String name = InputView.inputNames();
        String[] names = splitName(name);
        for (String n : names) {
            cars.add(new Car(n));
        }
    }

    private String[] splitName(String name) {
        return name.split(DELIMITER);
    }
}
