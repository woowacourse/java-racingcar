package util;

import java.util.Random;

public class RandomNumberMaker {

    public int makeNumber(){
        Random random = new Random();
        return random.nextInt(9);
    }
}
