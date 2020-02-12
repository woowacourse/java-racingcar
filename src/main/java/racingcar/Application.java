package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.io.userInput;

import java.util.List;

import static racingcar.Utils.enrollCars;
import static racingcar.Utils.splitCarsName;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars(enrollCars(splitCarsName(userInput.inputCarsName())));
        Game game = new Game(cars, userInput.inputIteration());
        game.playGame();
    }

}
