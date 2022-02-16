package racingcar.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.utils.Constant;
import racingcar.view.ResultView;

public class Game {

    private static final int RANDOM_RANGE = 10;
    private static final String COMMA_REGEX = ",";
    private static final int MINIMUM_NATURAL_NUMBER = 1;

    private static final String TRY_NO_PATTERN_REGEX = "^[0-9]*$";

    private static final Pattern TRY_NO_PATTERN = Pattern.compile(TRY_NO_PATTERN_REGEX);

    private int tryNo;
    private Cars cars;

    public Game(String carNames, String tryNo) {
        this.cars = generateCars(carNames);
        this.tryNo = checkTryNo(tryNo);
    }


    public boolean isEnd() {
        return tryNo == 0;
    }

    public void race() {
        moveCar(cars);
        tryNo--;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }


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

    private String[] splitByComma(String input) {
        return input.split(COMMA_REGEX);
    }

    private int checkTryNo(String input) {
        isNumeric(input);
        int tryNo = Integer.parseInt(input);
        isNaturalNumber(tryNo);
        return tryNo;

    }

    private void isNumeric(String input) {
        Matcher matcher = TRY_NO_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(Constant.NOT_NUMERIC_ERROR);
        }
    }

    private void isNaturalNumber(int input) {
        if (input < MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(Constant.MINIMUM_NATURAL_NUMBER_ERROR);
        }
    }

}
