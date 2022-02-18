package racingcar.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.utils.Constant;

public class Game {

    private static final int MINIMUM_NATURAL_NUMBER = 1;

    private static final String COMMA_REGEX = ",";
    private static final String TRY_NO_PATTERN_REGEX = "^[0-9]*$";

    private static final Pattern TRY_NO_PATTERN = Pattern.compile(TRY_NO_PATTERN_REGEX);

    private final Cars cars;
    private int tryNo;

    public Game(String carNames, String tryNo) {
        this.cars = generateCars(carNames);
        this.tryNo = checkTryNo(tryNo);
    }

    public boolean isEnd() {
        return tryNo == 0;
    }

    public void race() {
        cars.move();
        tryNo--;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    private Cars generateCars(String names) {

        List<Car> carItems = new ArrayList<>();

        for (String name : splitByComma(names)) {
            carItems.add(new Car(name));
        }

        return new Cars(carItems);

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
