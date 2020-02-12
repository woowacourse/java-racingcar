package racingcargame.view.exception;

import racingcargame.util.Spliter;

import java.util.HashSet;
import java.util.Set;

public class CarNameException {

    public static boolean validOneCar(String input) {
        return !input.contains(Spliter.DELIMITER);
    }

    public static boolean isDuplicatedNames(String[] input) {
        Set<String> carNames = new HashSet<>();
        for (String name : input) {
            if(carNames.contains(name)){
                return true;
            }
            carNames.add(name);
        }
        return false;
    }
}
