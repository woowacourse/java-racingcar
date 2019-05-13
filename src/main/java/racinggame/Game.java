package racinggame;

import java.util.List;


public class Game {

    private static final int MAX_RANDOM_VALUE = 10;

    public List<Car> playGame(List<Car> cars ) {
        for (Car car : cars) {
            car.move(randomValueGenerator());
            System.out.println(car.toString());
        }

        return cars;
    }

    private int randomValueGenerator() {
        return ((int) (Math.random() * MAX_RANDOM_VALUE));
    }
}
