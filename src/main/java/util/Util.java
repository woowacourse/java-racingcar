package util;

import domain.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {
    public static int getRandomNumber(){
        return new Random().nextInt(Const.RANGE_RAN_NUM);
    }

    public static void checkDuplicatedStringList(List<String> strList){
        List<String> tempList = new ArrayList<>();
        for(String str : strList){
            if(tempList.contains(str)){
                throw new IllegalArgumentException(Const.EX_NAME_DUPLE);
            }
            tempList.add(str);
        }
    }

    public static void checkStringListSize(List<String> stringList){
        if(stringList.size() == 0){
            throw new IllegalArgumentException(Const.EX_NAME_LEN);
        }
    }
}
