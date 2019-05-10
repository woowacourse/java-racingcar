package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private List<Car> cars;

    public RacingCar() {
        cars = new ArrayList<>();
    }

    public List<Car> process(String userInput, int numOfGame) {
        String[] carNames = makeCarNames(userInput);
        setCars(carNames);
        playEntireRound(numOfGame);

        return cars;
    }

    private String[] makeCarNames(String userInput) {
        return userInput.split(",");
    }

    private void setCars(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    private void playEntireRound(int numOfGame) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numOfGame; i++) {
            playOneRound();
        }
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.play();
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.println(car);
    }
}
