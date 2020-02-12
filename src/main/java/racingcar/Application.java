package racingcar;

import racingcar.domain.Car;
import racingcar.io.userInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = enrollCars(splitCarsName(userInput.inputCarsName()));
        Game game = new Game(cars, userInput.inputIteration());
    }

    private static List<Car> enrollCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(carNames).forEach(x-> cars.add(new Car(x)));
        return cars;
    }

    private static String[] splitCarsName(String carsNameInput) {
        String[] carNames = carsNameInput.trim()
                .replace(" ", "")
                .split(",");
        return carNames;
    }
}
