package racing.game;

import java.util.ArrayList;
import java.util.List;

public class CarNameInputHandler {
    public static List<Car> getCars(String input) throws Exception {
        String[] names = splitNames(input);
        return convertToCars(names);
    }

    static String[] splitNames(String names) {
        return names.split(",");
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

    static boolean checkRepetition(String name, List<Car> cars) throws Exception {
        for (Car car : cars) {
            if (car.matchCarName(name))
                return true;
        }
        return false;
    }
}
