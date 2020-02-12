package racingcar;

import racingcar.domain.Car;
import racingcar.io.userInput;

import java.util.List;

import static racingcar.Utils.enrollCars;
import static racingcar.Utils.splitCarsName;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = enrollCars(splitCarsName(userInput.inputCarsName()));
        Game game = new Game(cars, userInput.inputIteration());
    }

}
