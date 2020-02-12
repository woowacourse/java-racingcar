package racingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

public class RacingGame {


    public static boolean move(int random) {
        if (random >= 4){
            return true;
        }
        return false;
    }

    public static int generateRandom() {
        int random = (int)(Math.random()*10);
        return random;
    }
}
