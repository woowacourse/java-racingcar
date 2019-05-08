package view;

import domain.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<Car> readCars() {
        String inp = sc.nextLine();
        String [] names = inp.split(",");

        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public static int readNum() {
        return sc.nextInt();
    }
}
