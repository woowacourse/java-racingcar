package racingcar;

import racingcar.domain.Cars;
import racingcar.io.UserInput;

import java.util.Arrays;

import static racingcar.util.CarUtils.*;

public class Application {
    public static void main(String[] args) {
        Game game = initializeGame();
        game.playGame();
    }

    private static Game initializeGame() {
        try {
            String[] carsName = splitCarsName(UserInput.inputCarsName());
            detectDuplicateName(carsName);
            Cars cars = new Cars(enrollCars(carsName));
            return new Game(cars, UserInput.inputIteration());
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return initializeGame();
        }
    }
}