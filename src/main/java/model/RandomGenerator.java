package model;

import java.util.Random;

public class RandomGenerator {

    public static int run(){
        return new Random().nextInt(9);
    }
}
