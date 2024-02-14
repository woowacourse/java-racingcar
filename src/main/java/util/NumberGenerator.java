package util;

import java.util.Random;

public class NumberGenerator {
    public static Integer generate(){
        return new Random().nextInt(10);
    }
}
