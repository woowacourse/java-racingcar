package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    final static int MIN_CAR_LENGTH = 1;
    final static int MAX_CAR_LENGTH = 5;
    //List<Car> cars = new ArrayList<Car>();

    public static void main(String[] args) {
        addCar();
    }

    private static void addCar() {
        String string = InputView.InputCarNames();
        String[] names = splitCar(string);

        List<String> carNames = Arrays.asList(names);

        if(carNames.stream().distinct().count() != carNames.size()){
            System.out.println("중복된 이름은 안됩니다.\n 다시 입력해 주세요.");
            addCar();
        }

        if (string.length() <= 0 || names.length < MIN_CAR_LENGTH) {
            System.out.println("글자 수는 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
            addCar();
        }

        for (String name : names) {
            if (name.length() > MAX_CAR_LENGTH) {
                System.out.println("글자 수는 5글자 이내여야 합니다.\n다시 입력해 주세요.");
                addCar();
                break;
            }
        }
    }

    private static String[] splitCar(String names) {
        names.replaceAll(" ", "");
        return names.split(",");
    }
}
