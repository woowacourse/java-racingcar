package application.racing;

import java.util.Random;

public class Racing {
    public int generateRandomNumber() {
        double randomValue = Math.random();
        return (int)(randomValue * 9);
    }
}
