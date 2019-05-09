package racing.game;

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

    private static void checkValidity(String[] names) throws Exception {
        if (checkNoInput(names) || checkInvalidNameLength(names) || checkRepetition(names)) {
            throw new Exception("잘못된 입력입니다.");
        }
    }

    private static List<Car> convertToCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        return cars;
    }

    static String[] splitNames(String names) {
        return names.replaceAll(" ", "").split(",");
    }

    static boolean checkNoInput(String[] names) {
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

    static boolean checkInvalidNameLength(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() >= NAME_LENGTH_LIMIT) {
                return true;
            }
        }
        return false;
    }

    static boolean checkRepetition(String[] names) {
        HashSet<String> nameSet = new HashSet<>(Arrays.asList(names));
        return names.length != nameSet.size();
    }


}
