package racingcar;

import java.util.*;

public class CarGameLauncher {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>(Arrays.asList("asddfdfd", "asd"));
        boolean test = CarException.isOverLimit(nameList);
        System.out.println(test);

    }
}
