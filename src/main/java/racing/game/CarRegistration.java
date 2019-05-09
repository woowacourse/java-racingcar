package racing.game;

import racing.game.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarRegistration {
    public static List<Car> convertToCars(String nextLine) {
        List<Car> cars = new ArrayList<>();

        return cars;
    }

    public static String[] splitNames(String names) {
        return names.replaceAll(" ", "").split(",");
    }

    public static boolean checkNoInput(String[] names) {
        if (names.length == 0) {
            return true;
        }
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("")) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRepetition(String[] names) {
        HashSet<String> nameSet = new HashSet<>(Arrays.asList(names));
        return names.length != nameSet.size();
    }


}
