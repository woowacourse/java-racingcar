package racing.game;

import racing.game.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRegistration {
    public static List<Car> convertToCars(String nextLine) {
        List<Car> cars = new ArrayList<>();

        return cars;
    }

    public static String[] splitNames(String names) {
        return names.replaceAll(" ", "").split(",");
    }

    public static boolean checkNoInput(String[] names){
        if((names.length == 1 && names[0].equals("")) || names.length == 0){
            return true;
        }
        return false;
    }


}
