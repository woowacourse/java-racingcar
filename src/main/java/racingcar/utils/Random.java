package racingcar.utils;

public class Random {

    public static final int THRESHOLD = 4;

    public static int pickNumber(){
         return (int) (Math.random() * 10);
    }
}
