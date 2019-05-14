package racing.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Rounds {
    private static final int MAX_NO = 10;
    static final int ROUND_MIN_LIMIT = 1;
    static final int CAR_COUNT_MIN_LIMIT = 2;
    private static final String NAME_DELIMITER = ",";

    static List<Car> convertNamesToCars(String names) {
        List<Car> cars = new ArrayList<>();
        try {
            for (String name : splitNamesWithComma(names)) {
                makeCar(cars, name);
            }
        } catch (Exception e) {
            cars.clear();
        }
        return cars;
    }

    private static void makeCar(List<Car> cars, String name) throws Exception {
        checkRepetition(cars, name);
        Car car = new Car(name);
        cars.add(car);
    }

    static void checkRepetition(List<Car> cars, String name) throws Exception {
        for (Car car : cars) {
            if (car.matchCarName(name))
                throw new Exception();
        }
    }

    static String[] splitNamesWithComma(String names) throws Exception {
        String[] nameSplitted = names.split(NAME_DELIMITER);
        if (nameSplitted.length < CAR_COUNT_MIN_LIMIT)
            throw new Exception();
        return nameSplitted;
    }

    static int checkRoundNum(String roundInput) {
        try {
            int round = Integer.parseInt(roundInput);
            if (round < ROUND_MIN_LIMIT)
                throw new Exception();
            return round;
        } catch (Exception e) {
            return 0;
        }
    }

    private static int getRandomValue() {
        return (int) (Math.random() * MAX_NO);
    }

    static Result doRound(List<Car> cars) {
        Result result = new Result();
        for (Car car : cars) {
            car.move(getRandomValue());
            result.add(car.toString());
        }
        return result;
    }

    static List<Car> calculateChampions(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int winnerPosition = Collections.max(cars, (car1, car2) -> car1.compareTo(car2)).getPosition();
        for (Car car : cars) {
            if (car.matchPosition(winnerPosition))
                winners.add(car);
        }
        return winners;
    }
}
