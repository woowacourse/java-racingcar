package service;

import domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WinningRule {

    public static String winner(Map<Car, Integer> namesAndPositions) {
        List<String> winnerNames = new ArrayList<>();
        int maxValue = namesAndPositions.values().stream().mapToInt(x -> x).max().getAsInt();

        for (Car car : namesAndPositions.keySet()) {
            checkMaxValueKey(namesAndPositions, winnerNames, maxValue, car);
        }

        return String.join(", ", winnerNames);
    }

    private static void checkMaxValueKey(Map<Car, Integer> namesAndPositions,List<String> winnerNames,int maxValue, Car car) {
        if (namesAndPositions.get(car) == maxValue) {
            winnerNames.add(car.getName());
        }
    }

}
