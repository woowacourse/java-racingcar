package racingcar.utils;

public class Randoms {

    public static final int THRESHOLD = 4;

    public static int pickNumber(){
         return (int) (Math.abs(Math.random() * 10));
    }
}
