package racingcar;

import racingcar.domain.Cars;
import racingcar.io.UserInput;

import static racingcar.Utils.enrollCars;
import static racingcar.Utils.splitCarsName;

public class Application {
    public static void main(String[] args) {
        Game game = initializeGame();
        game.playGame();
    }

    private static Game initializeGame() {
        try {
            Cars cars = new Cars(enrollCars(splitCarsName(UserInput.inputCarsName())));
            return new Game(cars, UserInput.inputIteration());
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return initializeGame();
        }
    }
}