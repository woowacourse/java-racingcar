package racingcargame.view.exception;

import racingcargame.util.Spliter;

public class CarNameException {

    public static boolean validOneCar(String input) {
        return !input.contains(Spliter.DELIMITER);
    }
}
