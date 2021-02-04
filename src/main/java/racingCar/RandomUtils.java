package racingCar;

import java.util.Random;

public class RandomUtils {
    final static Random RANDOM = new Random();

    static int nextInt(int start, int end) {
        if(start < 0){
            throw new RuntimeException();
        }
        if(start > end){
            throw new RuntimeException();
        }
        if(start == end){
            return start;
        }
        return RANDOM.nextInt(end - start + 1) + start ;
    }
}
