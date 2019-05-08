package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Winner {
    private int maxPosition;
    private ArrayList<Car> winners;

    public Winner() {
        maxPosition = 0;
    }

    public void determineWinners(ArrayList<Car> cars) {
        //maxPosition
        //position 비교
    }

    private int getMaxPosistion(ArrayList<Car> cars) {
        int result = 0;

        for(Car car : cars){
            result = car.compareToPosition(result);
        }

        return result;
    }

    public void printWinners() {
        //
    }
}
