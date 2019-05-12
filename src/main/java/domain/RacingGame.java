package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static util.StringUtil.parseStringByComma;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(String inputString) {
        this.cars = getCarList(inputString);
    }

    private static List<Car> getCarList(String inputString) {
        List<String> names = parseStringByComma(inputString);
        List<Car> cars = new ArrayList<>();

        for (String carName : names) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> tryMove() {
        for (Car car : cars) {
            car.move(Rule.isMove(makeRandomNumber()));
        }
        return cars;
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(Rule.BOUND_RULE_NUMBER);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
