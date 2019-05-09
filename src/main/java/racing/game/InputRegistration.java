package racing.game;

import racing.game.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputRegistration {
    private static final int NAME_LENGTH_LIMIT = 6;

    public static List<Car> getCars(String input) throws Exception {
        String[] names = splitNames(input);
        checkValidity(names);
        return convertToCars(names);
    }

    public static int getRoundNumber(String input) throws Exception {
        int roundNumber = Integer.parseInt(input);
        if (roundNumber < 1) {
            throw new Exception();
        }
        return roundNumber;
    }

    public static void checkValidity(String[] names) throws Exception {
        if (checkNoInput(names) || checkInvalidNameLength(names) || checkRepetition(names)) {
            throw new Exception("잘못된 입력입니다.");
        }
    }

    public static List<Car> convertToCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

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

    public static boolean checkInvalidNameLength(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() >= NAME_LENGTH_LIMIT) {
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
