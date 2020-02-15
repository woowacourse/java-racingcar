package racing.model;

import java.util.List;
import java.util.ArrayList;

public class CarLineUp {
    private static List<Car> lineUp = new ArrayList<>();

    public static void add(Car car){
        lineUp.add(car);
    }

    public static boolean isContainAlready(String name){
        for (Car carAlready : lineUp){
            if (carAlready.isNameEqual(name)){
                return true;
            }
        }return false;
    }
}
