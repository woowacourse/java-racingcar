package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.RandomNumberPicker;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new RandomNumberPicker());
        controller.game();
    }
}
