package domain;

import java.util.ArrayList;

public class CarFactory {
    // 문자열을 받아 , 단위로 쪼개서 차들을 생성해주는 객체
    public static ArrayList<Car> newCars(String str) {
        String[] names = str.split(",", -1);

        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) cars.add(new Car(name));
        return cars;
    }
}
