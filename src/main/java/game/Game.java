package game;

import game.output.resultOutput;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static int MAX_NAME_LENGTH = 5;
    private static int MAX_RANDOM_NUMBER = 9;

    String removeBlank(String carNames) {
        return carNames.replace(" ", "").replace(",,", ",");
    }

    String[] splitWithComma(String carNames) {
        String carName = removeBlank(carNames);
        return carName.split(",");
    }

    boolean checkCarNamesLength(String[] carNames) {
        boolean isRightLength = true;

        for (String carName : carNames) {
            isRightLength = checkCarNameLength(isRightLength, carName);
        }

        return isRightLength;
    }

    boolean checkCarNameLength(boolean isRightLength, String carName) {
        return carName.length() <= MAX_NAME_LENGTH && isRightLength;
    }


    List<Car> createCarObject(String[] carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }


    int randomValueGenerator() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }

    void oneGame(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValueGenerator());
            resultOutput.eachGameOutput(car);
        }
        resultOutput.printNewLine();
    }
}
