package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Car {
    private final String name;
    private int position;

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static List<String> askCarNames(){
        return CarException.askCarNamesException();
    }

    public static int askTotalTurns() {
        return CarException.askTotalTurnsException();
    }

}
