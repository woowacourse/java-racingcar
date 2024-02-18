package model;

import java.util.Random;

public class Power {

    public static int generatePower() {
        Random power = new Random();
        return power.nextInt(10);
    }
}
