package racingcar;

import racingcar.domain.CarFactory;
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
            CarFactory carFactory = new CarFactory(UserInput.inputCarsName());
            return new Game(carFactory.enrollCars(), UserInput.inputIteration());
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return initializeGame();
        }
    }
}