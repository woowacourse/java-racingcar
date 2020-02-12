package racingcar;

import racingcar.domain.Cars;
import racingcar.io.UserInput;

import static racingcar.util.CarUtils.enrollCars;
import static racingcar.util.CarUtils.splitCarsName;

public class Application {
    public static void main(String[] args) {
        Game game = initializeGame();
        game.playGame();
    }

    private static Game initializeGame() {
        try {
            String[] carsName = splitCarsName(UserInput.inputCarsName());
            Cars cars = new Cars(enrollCars(carsName));
            return new Game(cars, UserInput.inputIteration());
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return initializeGame();
        }
    }
}