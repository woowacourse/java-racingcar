package view;

import model.Car;

public class OutputView {
    public static String printPositionBar(Car car) {
        int position = car.getPosition();
        return makePositionBar(position);
    }

    private static String makePositionBar(int position) {
        return new String(new char[position]).replace("\0", "-");
    }
}
