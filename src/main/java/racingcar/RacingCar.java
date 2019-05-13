package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static final int RANDOM_NUMBER_LIMIT = 10;

    private List<Car> cars;
    private RacingResult racingResult;

    public RacingCar() {
        cars = new ArrayList<>();
    }

    public ArrayList<Integer>[] process(String userInput, int numOfGame) {
        String[] carNames = splitCarNames(userInput);
        setCars(carNames);
        racingResult = new RacingResult(carNames);
        playEntireRound(numOfGame);

        return racingResult.getCarPositionHistory();
    }

    public String[] splitCarNames(String userInput) {
        return userInput.split(",");
    }

    private void setCars(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    private void playEntireRound(int numOfGame) {
        for (int i = 0; i < numOfGame; i++) {
            playOneRound();
        }
    }

    private void playOneRound() {
        for (int i = 0; i < cars.size(); i++) {
            moveOneCar(cars.get(i));
            racingResult.recordCarPositionHistory(i, cars.get(i));
        }
    }

    private void moveOneCar(Car car) {
        int randomNumber = makeRandomNumber();
        car.move(randomNumber);
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_LIMIT);
    }
}
