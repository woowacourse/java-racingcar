package util;

import domain.Const;

import java.util.Random;

public class Util {
    public static int getRandomNumber(){
        return new Random().nextInt(Const.RANGE_RAN_NUM);
    }
}
