package utils;

import java.util.Random;

public class RandomUtils {
    final static Random RANDOM = new Random();

    public static int nextInt(final int START, final int END) {
        if(START < 0 || START > END){
            throw new RuntimeException("입력 값을 확인해주세요.");
        }
        if(START == END){
            return START;
        }
        return RANDOM.nextInt(END - START + 1) + START ;
    }
}
