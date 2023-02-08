package util;

import domain.Car;

import java.util.List;

public class Finder {
    public static int findMaxStep(List<Car> cars) {
        int maxStep = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxStep = compareStep(car, maxStep);
        }
        return maxStep;
    }

    private static int compareStep(Car car, int maxStep){
        return Math.max(car.getStep(), maxStep);
    }

}
