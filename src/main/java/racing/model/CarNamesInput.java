package racing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNamesInput {

    public static List<Car> getCars(String input) throws Exception {
        String[] names = splitNames(input);
        checkCarNamesValidity(names);
        return convertToCars(names);
    }

    public static String[] splitNames(String names) {

        return names.replaceAll(" ", "").split(",");
    }


    private static void checkCarNamesValidity(String[] names) throws Exception {
        if (checkNoInput(names) || checkRepetition(names)) {
            throw new Exception("잘못된 입력입니다.");
        }
    }

    static boolean checkNoInput(String[] names) {
        return names.length == 0;
    }


    static boolean checkRepetition(String[] names) {
        HashSet<String> nameSet = new HashSet<>(Arrays.asList(names));
        return names.length != nameSet.size();
    }

    private static List<Car> convertToCars(String[] names) throws Exception {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        return cars;
    }


}
