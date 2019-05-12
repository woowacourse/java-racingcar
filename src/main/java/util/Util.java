package util;

import domain.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
    public static int getRandomNumber() {
        return new Random().nextInt(Const.RANGE_RAN_NUM);
    }

    public static void checkCarNameZeroSize(List<String> stringList) {
        if (stringList.size() == Const.ZERO) {
            throw new IllegalArgumentException(Const.EX_NAME_LEN);
        }
    }
}
