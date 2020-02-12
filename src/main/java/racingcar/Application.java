package racingcar;

import racingcar.domain.Cars;
import racingcar.io.UserInput;

import java.util.Arrays;

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
            String[] carsNameWithoutDuplicate = Arrays.asList(carsName).toArray(new String[0]);
            if(carsName != carsNameWithoutDuplicate) {
                throw new IllegalArgumentException("중복된 이름을 사용할 수 없습니다.");
            }
            Cars cars = new Cars(enrollCars(carsName));
            return new Game(cars, UserInput.inputIteration());
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return initializeGame();
        }
    }
}