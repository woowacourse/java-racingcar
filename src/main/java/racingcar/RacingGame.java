package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    final static int MAX_CAR_LENGTH = 5;
    //List<Car> cars = new ArrayList<Car>();

    public static void main(String[] args) {
        addCar();
    }

    private static void addCar() {
        String string = InputView.InputCarNames();

        String[] names = splitCar(string);
        for (String name: names) {
            if (name.length() > MAX_CAR_LENGTH ) {
                System.out.println(name);
                System.out.println("글자 수는 5글자 이내여야 합니다.\n 다시 입력해 주세요.");
                addCar();
                break;
            }
        }
    }

    private static String[] splitCar(String names) {
        return names.split(",");
    }
}
