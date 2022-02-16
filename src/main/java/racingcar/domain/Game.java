package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import racingcar.utils.Constant;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final OutputView output = new OutputView();

    private static final int RANDOM_RANGE = 10;
    private static final String COMMA_REGEX = ",";

    private int tryNo;
    private Cars cars;

    public Game(String carNames, int tryNo) {
        this.cars = generateCars(carNames);
        this.tryNo = tryNo;
    }


    public boolean isEnd() {
        return tryNo == 0;
    }

    public void race() {
        moveCar(cars);
        output.printPosition(cars.getCars());
        tryNo--;
    }

    public void getWinners() {
        List<String> winners = cars.getWinners();
        output.printWinner(winners);
    }


//    private void race(int coin, Cars cars) {
//
//        output.printResultMessage();
//        for (int index = 0; index < coin; index++) {
//            moveCar(cars);
//            output.printPosition(cars.getCars());
//        }
//    }

    private void moveCar(Cars cars) {
        for (Car car : cars.getCars()) {
            car.movePosition(makeRandom());
        }
    }

    private int makeRandom() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    private Cars generateCars(String names) {
        List<Car> cars = new ArrayList<>();

        for (String name : splitByComma(names)) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    public  String[] splitByComma(String input) {
        return input.split(COMMA_REGEX);
    }


}
