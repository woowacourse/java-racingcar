package racing.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputRegistration {
    private static final int ROUND_MIN_LIMIT = 1;

    public static List<Car> getCars(String input) throws Exception {
        String[] names = splitNames(input);
        checkValidity(names);
        return convertToCars(names);
    }

    public static int getRoundNumber(String input) throws Exception {
        int roundNumber = Integer.parseInt(input);
        if (roundNumber < ROUND_MIN_LIMIT) {
            throw new Exception();
        }
        return roundNumber;
    }

    private static void checkValidity(String[] names) throws Exception {
        if (checkRepetition(names)) {
            throw new Exception();
        }
    }

    /* Car 클래스로 이동 예정
    static boolean checkInvalidNameLength(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() >= Car.NAME_LENGTH_MAX_LIMIT) {
                return true;
            }
        }
        return false;
    }
    */

    private static List<Car> convertToCars(String[] names) throws Exception {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    static String[] splitNames(String names) {
        return names.replaceAll(" ", "").split(",");
    }

    static boolean checkRepetition(String[] names) {
        HashSet<String> nameSet = new HashSet<>(Arrays.asList(names));
        return names.length != nameSet.size();
    }


}
