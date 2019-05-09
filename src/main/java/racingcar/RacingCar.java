package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private List<Car> cars = new ArrayList<>();

    public void run() {
        String userInput = InputView.getUserCarNames();
        String[] carNames = makeCarNames(userInput);
        setCars(carNames);
        int numOfGames = InputView.getNumberOfGame();
    }

    private String[] makeCarNames(String userInput) {
        String[] carNames = userInput.split(",");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }

        return carNames;
    }

    private void setCars(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    private void startGame(int numOfGame) {
        for (int i = 0; i < numOfGame; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.play();
        }
    }

    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        racingCar.run();
    }
}
