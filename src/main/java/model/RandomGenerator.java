package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    public static List<Integer> run(int carSize){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < carSize; i++) {
            result.add(new Random().nextInt(9));
        }
        return result;
    }
}
