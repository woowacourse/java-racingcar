package view;

import model.Car;

public class OutputView {
    public static String visualizePosition(Car car) {
        int position = car.getPosition();
        return new String(new char[position]).replace("\0", "-");
    }
}
