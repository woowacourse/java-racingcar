package racing.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputRegistration {
    private static final int ROUND_MIN_LIMIT = 1;

    public static List<Car> getCars(String input) throws Exception {
        String[] names = splitNames(input);
        return convertToCars(names);
    }

    public static int getRoundNumber(String input) throws Exception {
        int roundNumber = Integer.parseInt(input);
        if (roundNumber < ROUND_MIN_LIMIT) {
            throw new Exception();
        }
        return roundNumber;
    }

    static boolean checkRepetition(String name, List<Car> cars) throws Exception {
        for (Car car : cars) {
            if (car.matchCarName(name))
                return true;
        }
        return false;
    }

    private static List<Car> convertToCars(String[] names) throws Exception {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            checkRepetition(names[i], cars);
            Car car = new Car(names[i].trim());
            cars.add(car);
        }
        return cars;
    }

    static String[] splitNames(String names) {
        return names.split(",");
    }

}
